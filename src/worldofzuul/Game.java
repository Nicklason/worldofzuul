package worldofzuul;

import java.awt.Container;
import java.util.ArrayList;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    private Inventory inventory = new Inventory(1);
    public ArrayList<Room> roomList = new ArrayList<>();

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        // Rooms
        Room lobby = new Room("Lobby", "In the Lobby Start/End");
        Room lake = new Room("Lake", "At the lake");
        Room bigCity = new Room("Big City", "In the Big City");
        Room field = new Room("Field", "At the field");
        Room suburbs = new Room("Suburbs", "In the suburban neighbourhood");
        Room street = new Room("Street", "In the street");
        Room factory = new Room("Factory", "At the factory");
        roomList.add(lake);
        roomList.add(bigCity);
        roomList.add(field);
        roomList.add(suburbs);
        roomList.add(street);
        roomList.add(factory);
        
        // Points of interest
        
        PointOfInterest boat, leakingpipe, bridge, irrigation, farmhouse, pesticides, waterpump, Street, boy, vendingMachine, store, oldMan, closedDoor, container, map;
        boat = new PointOfInterest("boat", "You see a boat in the sea. The boats engine is leaking into the water and the water surrounding the boat is contaminated",
                "you used the boots to get out and fix the leaking boat engine.");
        leakingpipe = new PointOfInterest("leakingpipe", "A pipeline is broken and leaking chemicals on the ground and into the water.",
                "You have fixed the leaking pipe");
        bridge = new PointOfInterest("bridge", "A small bridge is falling aparat maybe there is something usefull",
                "");
        irrigation = new PointOfInterest("irrigation", "The irrigation system is missing a pipe, water is running out on the ground",
                "You hav fixed the irrigation system, water is not getting wasted anymore");
        farmhouse = new PointOfInterest("farmhouse", "An abandoned farmhouse, maybe something usefull");
        pesticides = new PointOfInterest("pesticides", "an open box of pesticides is laying on the ground, if on you could move it",
                "You have moved the pesticides from the ground they are no longer contaminating the ground");
        waterpump = new PointOfInterest("waterpump", "a handle is missing on the water pump",
                "You have replaced the missing handle, the water pump is now fully functional");
        Street = new PointOfInterest("street", "you are standing at the street leading through the suburbs",
                "");
        boy = new PointOfInterest("boy", "Hello my name is _____ I am really thirsty if only someone could replace it missing handle on our water pump!",
                "Thank you so much for fixing the water pump");
        vendingMachine = new PointOfInterest("vendingMachine", "A cola vending machine, it requires a coin", "you used the coin and got a cola");
        store = new PointOfInterest("store", "A grocery store, there is a line of shoppingcarts at the front they require a coin", "You used the coin to unlock a shopping cart");
        oldMan = new PointOfInterest("oldman", "An old man", "you helped the old man get water");
        closedDoor = new PointOfInterest("lockeddoor", "locked backdoor into factory", "you used the keycart to unlock the door");
        container = new PointOfInterest("container", "garbage container, maybe there is something still usefull");
        
        map = new PointOfInterest("map", "map showing water requirements for producing 1 liter of cola ");

        // Lobby
        lobby.setExit("lake", lake);

        // Lake
        boat.inventory.add(new Item("pipe", "A pipe", irrigation));
        lake.setPointOfInterest(boat);
        lake.setPointOfInterest(leakingpipe);
        lake.setPointOfInterest(bridge);

        lake.setExit("lobby", lobby);
        lake.setExit("bigcity", bigCity);
        lake.setExit("field", field);

        // Field
        farmhouse.inventory.add(new Item("boots", "A pair of boots", boat));
        farmhouse.inventory.add(new Item("meatalpatch", "A metal patch", leakingpipe));
        irrigation.inventory.add(new Item("pumpHandle", "A pump handle", waterpump));
        field.setPointOfInterest(farmhouse);
        field.setPointOfInterest(irrigation);
        field.setPointOfInterest(pesticides);

        field.setExit("lake", lake);
        field.setExit("suburbs", suburbs);

        // Suburbs
        Street.inventory.add(new Item("coin", "A golden coin", vendingMachine));
        suburbs.setPointOfInterest(waterpump);
        suburbs.setPointOfInterest(Street);
        suburbs.setPointOfInterest(boy);
        suburbs.setExit("field", field);
        suburbs.setExit("bigcity", bigCity);
        

        // Big city
        vendingMachine.inventory.add(new Item("cola", "A can of cola", boy));
        store.inventory.add(new Item("cart", "A shopping chart", pesticides));
        oldMan.inventory.add(new Item("keycart", "A keycart", closedDoor));
        bigCity.setPointOfInterest(vendingMachine);
        bigCity.setPointOfInterest(store);
        bigCity.setPointOfInterest(oldMan);
        bigCity.setExit("lake", lake);
        bigCity.setExit("street", street);
        bigCity.setExit("suburbs", suburbs);

        // Street
        container.inventory.add(new Item("camera", "A digital camera", map));
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

        if (item.usableAtPointOfInterest(currentPointOfInterest)) {
            System.out.println("Using " + item.getName() + " at " + currentPointOfInterest.getName());
            currentPointOfInterest.setFixed();
            System.out.println(currentPointOfInterest.getLongDescription());
            this.inventory.remove(item);
        } else {
            System.out.println("You cant use that item here");
        }
    }

    private void viewInventory() {
        System.out.println("Your items: " + this.inventory.getItemsString());
    }
    
    private void highscore(){
        int fixedCount = 0;
        for (Room room: roomList){
            room.getpointsOfInterestsArrayList();
               for (PointOfInterest poi: room.getpointsOfInterestsArrayList()){
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
