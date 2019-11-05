package worldofzuul;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    private Inventory inventory = new Inventory();

    public Game () {
        createRooms();
        parser = new Parser();
    }

    private void createRooms()
    {
        Room lobby = new Room("Lobby", "In the Lobby Start/End");
        Room lake = new Room("Lake", "At the lake");
        Room bigCity = new Room("Big City", "In the Big City");
        Room field = new Room("Field", "At the field");
        Room suburbs = new Room("Suburbs", "In the suburban neighbourhood");
        Room street = new Room("Street", "In the street");
        Room factory = new Room("Factory", "At the factory");

        // Lobby
        lobby.setExit("lake", lake);

        // Lake
        PointOfInterest boat = new PointOfInterest("boat", "You see a boat in the lake. The boat's engine is broken and has contaminated the surrounding water.");
        boat.inventory.add(new Pipe(this));
        lake.setPointOfInterest(boat);

        lake.setExit("lobby", lobby);
        lake.setExit("bigcity", bigCity);
        lake.setExit("field", field);

        // Field
        PointOfInterest leakingpipe = new PointOfInterest("leakingpipe", "A pipeline is broken and leaking chemicals on the ground and into the water.");
        field.setPointOfInterest(leakingpipe);

        PointOfInterest farmhouse = new PointOfInterest("farmhouse", "An abandoned farmhouse, maybe it contains something useful?");
        farmhouse.inventory.add(new Boots(this));
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

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

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
        
        String pointOfInterestName = command.getSecondWord();
        
        PointOfInterest pointOfInterest = currentRoom.getPointOfInterest(pointOfInterestName);

        System.out.println(pointOfInterestName);

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

        String itemName = command.getSecondWord();

        Item item = this.currentPointOfInterest.inventory.get(itemName);

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
