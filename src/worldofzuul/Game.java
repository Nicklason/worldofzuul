package worldofzuul;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    private Inventory inventory = new Inventory(1);

    public Game () {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
        // Rooms
        Room lobby = new Room("Lobby", "In the Lobby Start/End");
        Room lake = new Room("Lake", "At the lake");
        Room bigCity = new Room("Big City", "In the Big City");
        Room field = new Room("Field", "At the field");
        Room suburbs = new Room("Suburbs", "In the suburban neighbourhood");
        Room street = new Room("Street", "In the street");
        Room factory = new Room("Factory", "At the factory");

        // Points of interest
        PointOfInterest leakingpipe = new PointOfInterest("leakingpipe", "A pipeline is broken and leaking chemicals on the ground and into the water.", "You have fixed the leaking pipe.");
        PointOfInterest boat = new PointOfInterest("boat", "You see a boat in the lake. The boat's engine is broken and has contaminated the surrounding water.", "You used the boots to get out and fixed the leaking boat engine.");
        PointOfInterest farmhouse = new PointOfInterest("farmhouse", "An abandoned farmhouse, maybe it contains something useful?");

        // Lobby
        lobby.setExit("lake", lake);

        // Lake
        boat.inventory.add(new Item("pipe", "A pipe", leakingpipe));
        lake.setPointOfInterest(boat);

        lake.setExit("lobby", lobby);
        lake.setExit("bigcity", bigCity);
        lake.setExit("field", field);

        // Field
        field.setPointOfInterest(leakingpipe);

        farmhouse.inventory.add(new Item("boots", "A pair of boots", boat));
        field.setPointOfInterest(farmhouse);

        field.setExit("lake", lake);
        field.setExit("suburbs", suburbs);

        // Suburbs
        suburbs.setExit("field", field);
        suburbs.setExit("bigcity", bigCity);

        // Big city
        bigCity.setExit("lake", lake);
        bigCity.setExit("street", street);
        bigCity.setExit("suburbs", suburbs);

        // Street
        street.setExit("bigcity", bigCity);
        street.setExit("factory", factory);

        // Factory
        factory.setExit("street", street);

        currentRoom = lobby;
        currentPointOfInterest = null;
    }

    public void play () {            
        printWelcome();
                
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing. Good bye.");
    }

    private void printWelcome () {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand (Command command) {
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
        }
        return wantToQuit;
    }

    private void printHelp () {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom (Command command) {
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

    private void investigatePointOfInterest (Command command) {
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

    private void pickupItem (Command command) {
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
            System.out.println("The item has been added to your inventory");
        } else {
            System.out.println("You can't carry more items!");
        }
    }

    private void dropItem (Command command) {
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

    private void useItem (Command command) {
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
            this.inventory.remove(item);
        } else {
            System.out.println("You cant use that item here");
        }
    }

    private void viewInventory () {
        System.out.println("Your items: " + this.inventory.getItemsString());
    }

    private boolean quit (Command command) {
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
