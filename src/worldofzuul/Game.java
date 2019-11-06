package worldofzuul;

import items.*;

import java.util.ArrayList;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    public Inventory inventory = new Inventory(1);
    public ArrayList<Room> rooms = new ArrayList<>();

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        // Rooms
        Room lobby = new Room("lobby", "In the Lobby Start/End");
        Room lake = new Room("lake", "At the lake");
        Room bigCity = new Room("bigcity", "In the Big City");
        Room field = new Room("field", "At the field");
        Room suburbs = new Room("suburbs", "In the suburban neighbourhood");
        Room street = new Room("street", "In the street");
        Room factory = new Room("factory", "At the factory");

        rooms.add(lake);
        rooms.add(bigCity);
        rooms.add(field);
        rooms.add(suburbs);
        rooms.add(street);
        rooms.add(factory);
        
        // Points of interest
        PointOfInterest boat = new PointOfInterest("boat", "You see a boat in the sea. The boats engine is leaking into the water and the water surrounding the boat is contaminated", "you used the boots to get out and fix the leaking boat engine.");
        PointOfInterest leakingpipe = new PointOfInterest("leakingpipe", "A pipeline is broken and leaking chemicals on the ground and into the water.", "You have fixed the leaking pipe");
        PointOfInterest bridge = new PointOfInterest("bridge", "A small bridge is falling aparat maybe there is something usefull");
        PointOfInterest irrigation = new PointOfInterest("irrigation", "The irrigation system is missing a pipe, water is running out on the ground", "You hav fixed the irrigation system, water is not getting wasted anymore");
        PointOfInterest farmhouse = new PointOfInterest("farmhouse", "An abandoned farmhouse, maybe something usefull");
        PointOfInterest pesticides = new PointOfInterest("pesticides", "an open box of pesticides is laying on the ground, if on you could move it", "You have moved the pesticides from the ground they are no longer contaminating the ground");
        PointOfInterest waterpump = new PointOfInterest("waterpump", "a handle is missing on the water pump", "You have replaced the missing handle, the water pump is now fully functional");
        PointOfInterest streetPoi = new PointOfInterest("street", "you are standing at the street leading through the suburbs");
        PointOfInterest boy = new PointOfInterest("boy", "Hello my name is _____ I am really thirsty if only someone could replace it missing handle on our water pump!", "Thank you so much for fixing the water pump");
        PointOfInterest vendingMachine = new PointOfInterest("vendingmachine", "A cola vending machine, it requires a coin", "you used the coin and got a cola");
        PointOfInterest store = new PointOfInterest("store", "A grocery store, there is a line of shoppingcarts at the front they require a coin", "You used the coin to unlock a shopping cart");
        PointOfInterest oldMan = new PointOfInterest("oldman", "An old man", "you helped the old man get water");
        PointOfInterest closedDoor = new PointOfInterest("lockeddoor", "locked backdoor into factory", "you used the keycart to unlock the door");
        PointOfInterest container = new PointOfInterest("container", "garbage container, maybe there is something still usefull");
        PointOfInterest map = new PointOfInterest("map", "map showing water requirements for producing 1 liter of cola ");

        // Lobby
        lobby.setExit("lake", lake);

        // Lake
        // boat.inventory.add(new Item("pipe", "A pipe", irrigation));
        lake.setPointOfInterest(boat);
        lake.setPointOfInterest(leakingpipe);
        lake.setPointOfInterest(bridge);

        lake.setExit("lobby", lobby);
        lake.setExit("bigcity", bigCity);
        lake.setExit("field", field);

        // Field
        farmhouse.inventory.add(new Boots(this));

        // farmhouse.inventory.add(new Item("meatalpatch", "A metal patch", leakingpipe));
        // irrigation.inventory.add(new Item("pumpHandle", "A pump handle", waterpump));
        field.setPointOfInterest(farmhouse);
        field.setPointOfInterest(irrigation);
        field.setPointOfInterest(pesticides);

        field.setExit("lake", lake);
        field.setExit("suburbs", suburbs);

        // Suburbs
        // streetPoi.inventory.add(new Item("coin", "A golden coin", vendingMachine));
        suburbs.setPointOfInterest(waterpump);
        suburbs.setPointOfInterest(streetPoi);
        suburbs.setPointOfInterest(boy);
        suburbs.setExit("field", field);
        suburbs.setExit("bigcity", bigCity);
        

        // Big city
        // vendingMachine.inventory.add(new Item("cola", "A can of cola", boy));
        // store.inventory.add(new Item("cart", "A shopping chart", pesticides));
        // oldMan.inventory.add(new Item("keycart", "A keycart", closedDoor));
        bigCity.setPointOfInterest(vendingMachine);
        bigCity.setPointOfInterest(store);
        bigCity.setPointOfInterest(oldMan);
        bigCity.setExit("lake", lake);
        bigCity.setExit("street", street);
        bigCity.setExit("suburbs", suburbs);

        // Street
        // container.inventory.add(new Item("camera", "A digital camera", map));
        street.setPointOfInterest(closedDoor);
        street.setPointOfInterest(container);
        street.setExit("bigcity", bigCity);
        street.setExit("factory", factory);

        // Factory
        factory.setPointOfInterest(map);
        factory.setExit("street", street);

        currentRoom = lobby;
        currentPointOfInterest = null;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing. Good bye.");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if (commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        } else if (commandWord == CommandWord.GO) {
            goRoom(command);
        } else if (commandWord == CommandWord.INVESTIGATE) {
            investigatePointOfInterest(command);
        } else if (commandWord == CommandWord.INVENTORY) {
            viewInventory();
        } else if (commandWord == CommandWord.PICKUP) {
            pickupItem(command);
        } else if (commandWord == CommandWord.DROP) {
            dropItem(command);
        } else if (commandWord == CommandWord.USE) {
            useItem(command);
        } else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        } else if (commandWord == CommandWord.INFORMATION) {
            printRoomInformation();
        } else if (commandWord == CommandWord.FINISH) {
            highscore();
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void printRoomInformation() {
        System.out.println(currentRoom.getLongDescription());

    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        Room nextRoom = currentRoom.getExit(command.getSecondWord());

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            currentPointOfInterest = null;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private void investigatePointOfInterest(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("You are not looking at anything!");
            return;
        }

        PointOfInterest pointOfInterest = currentRoom.getPointOfInterest(command.getSecondWord());

        if (pointOfInterest == null) {
            System.out.println("Could not find what you were looking for");
        } else {
            currentPointOfInterest = pointOfInterest;
            System.out.println(currentPointOfInterest.getLongDescription());
        }
    }

    private void pickupItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Pickup what?");
            return;
        }

        Item item = this.currentPointOfInterest.inventory.get(command.getSecondWord());

        if (item == null) {
            System.out.println("Could not find the item");
            return;
        }

        if (this.inventory.add(item)) {
            this.currentPointOfInterest.inventory.remove(item);
            System.out.println("The "+item.getName()+" has been added to your inventory");
        } else {
            System.out.println("You can't carry more items!");
        }
    }

    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        String itemName = command.getSecondWord();

        Item item = this.inventory.get(itemName);

        if (item == null) {
            System.out.println("Could not find the item");
            return;
        }

        if (this.currentPointOfInterest.inventory.add(item)) {
            this.inventory.remove(item);
            System.out.println("The item has been removed from your inventory");
        } else {
            System.out.println("You can't carry more items!");
        }
    }

    private void useItem(Command command) {
        if (this.currentPointOfInterest == null) {
            System.out.println("You are not investigating anything");
            return;
        }

        if (!command.hasSecondWord()) {
            System.out.println("Which item do you want to use?");
            return;
        }

        Item item = inventory.get(command.getSecondWord());

        // PointOfInterest pointOfInterest = currentRoom.getPointOfInterest(pointOfInterestName);
        if (item == null) {
            System.out.println("Could not find the item");
            return;
        }

        item.use();
    }

    private void viewInventory() {
        System.out.println("Your items: " + this.inventory.getItemsString());
    }
    
    private void highscore(){
        int fixedCount = 0;
        for (Room room: rooms){
            for (PointOfInterest poi: room.getPointsOfInterests ()){
                if (poi.isFixed()) {
                    fixedCount++;
                }
            }
        }
        System.out.println(fixedCount);
        System.out.println("Highscore: "+(fixedCount*100)+" you fixed "+fixedCount+" objectives");
    }

    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public PointOfInterest getCurrentPointOfInterest() {
        return currentPointOfInterest;
    }
}
