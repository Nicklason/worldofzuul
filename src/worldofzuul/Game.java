package worldofzuul;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    private Inventory inventory;

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room lobby, lake, bigCity, field, suburbs, street, factory;
      
        lobby = new Room("In the Lobby Start/End","Lobby");
        lake = new Room("At the lake","Lake");
        bigCity = new Room("In the Big City", "Big City");
        field = new Room("At the field","Field");
        suburbs = new Room("In the suburban neighbourhood", "suburbs");
        street = new Room("In the street","Street");
        factory = new Room("At the factory","factory");
        
        
        
        /**
         * Exits from lobby
         */
        lobby.setExit("west", lake);
        
        /**
         * Exits from lake
         */
        lake.setExit("east", lobby);
        lake.setExit("west", bigCity);
        lake.setExit("south", field);
        
        /**
         * Exits from field
         */
        field.setExit("north", lake);
        field.setExit("west", suburbs);
        
        /**
         * Exits from suburbs
         */
        suburbs.setExit("East", field);
        suburbs.setExit("north", bigCity);
        
        /**
         * Exits from bigCity
         */
        bigCity.setExit("east", lake);
        bigCity.setExit("west", street);
        bigCity.setExit("south", suburbs);
        
        /**
         * Exits from street
         */
        street.setExit("east", bigCity);
        street.setExit("west", factory);
       
        /**
         * Exits from factory
         */
        factory.setExit("east", street);
        
        

        currentRoom = lobby;
        currentPointOfInterest = null;
    }

    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            currentPointOfInterest = null;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
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
