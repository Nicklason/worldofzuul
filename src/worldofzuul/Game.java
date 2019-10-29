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
      
        lobby = new Room("In the Lobby Start/End");
        lake = new Room("At the lake");
        bigCity = new Room("In the Big City");
        field = new Room("At the field");
        suburbs = new Room("In the suburban neighbourhood");
        street = new Room("In the street");
        factory = new Room("At the factory");
        
        /**
         * Exits from lobby
         */
        lobby.setExit("lake", lake);
        
        /**
         * Exits from lake
         */
        lake.setExit("lobby", lobby);
        lake.setExit("bigcity", bigCity);
        lake.setExit("field", field);
        
        /**
         * Exits from field
         */
        field.setExit("lake", lake);
        field.setExit("suburbs", suburbs);
        
        /**
         * Exits from suburbs
         */
        suburbs.setExit("field", field);
        suburbs.setExit("bigcity", bigCity);
        
        /**
         * Exits from bigCity
         */
        bigCity.setExit("lake", lake);
        bigCity.setExit("street", street);
        bigCity.setExit("suburbs", suburbs);
        
        /**
         * Exits from street
         */
        street.setExit("bigcity", bigCity);
        street.setExit("factory", factory);
       
        /**
         * Exits from factory
         */
        factory.setExit("street", street);
        
        

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
}
