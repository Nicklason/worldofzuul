package worldofzuul;

import java.util.ArrayList;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    private Inventory inventory = new Inventory(1);
    public ArrayList<Room> rooms = new ArrayList<>();
    
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

        rooms.add(lake);
        rooms.add(bigCity);
        rooms.add(field);
        rooms.add(suburbs);
        rooms.add(street);
        rooms.add(factory);
        
        // Points of interest
         // Points of interest
        PointOfInterest boat = new PointOfInterest("boat",
                                                   "You see an old motorboat abandoned in the sea.\n"
                                                 + "The boats rusty gastank is leaking into the water"
                                                 + "There are black oily stains all around the boat\n"
                                                 + "I am not going into that water without some rubberboots!",
                                                   "Looks much beter\n"
                                                 + "nothing is running out into the water from the boat\n"
                                                 + "The gasoline is not polluting the lake anymore");
        PointOfInterest leakingpipe = new PointOfInterest("leakingpipe",
                                                   "The old pipeline is comming from the city. \n"
                                                 + "What is that smell?\n"
                                                 + "There is a hole in the pipeline \n"
                                                 + "Stinky sewage water is running into the lake.",
                                                   "The leaking pipe is now fixed \n"
                                                 + "Sewage doesn't belong in this beautiful lake");
        PointOfInterest bridge = new PointOfInterest("bridge",
                                                   "A small bridge is falling aparat \n"
                                                 + "maybe there is something usefull there...");
        PointOfInterest irrigation = new PointOfInterest("irrigation",
                                                    "There is a large system of watering pipes in the field \n"
                                                  + "Splat!\n"
                                                  + "Splat!\n"
                                                  + "Splat\n"
                                                  + "Why is there water on the ground?\n"
                                                  + "The irrigation system is missing a pipe",
                                                    "You have fixed the irrigation system, water is not getting wasted anymore");
        PointOfInterest farmhouse = new PointOfInterest("farmhouse",
                                                    "An abandoned farmhouse,\n"
                                                  + "Maybe there is something usefull inside");
        PointOfInterest pesticides = new PointOfInterest("pesticides",
                                                    "An open bag of pesticides on the ground,\n"
                                                  + "Oh, no!\n"
                                                  + "The poison is running out into the ground\n"
                                                  + "The bag looks heavy\n"
                                                  + "I need something move it", 
                                                    "You have removed the pesticides from the ground\n"
                                                  + "The ground water is free from that poison now");
        PointOfInterest waterpump = new PointOfInterest("waterpump",
                                                    "You see a big water tank with a pump by the house\n"
                                                  + "There are pipes from the roof connected to it\n"
                                                  + "Collecting rain water \n"
                                                  + "That is really smart!\n "
                                                  + "The pump looks strange though, the handle is mising",
                                                    "The pump is functional again\n"
                                                  + "There is free rain water again");
        PointOfInterest well = new PointOfInterest("well",
                                                    "Looks like an old well \n"
                                                  + "Fesh local water from the underground\n"
                                                  + "I wish people used them some more...");           
        PointOfInterest boy = new PointOfInterest("boy",
                                                    "Hello my name is Will.\n"
                                                  + "I was playing with the water pipe\n"
                                                  + "and broke the handle!\n"
                                                  + "I am not alloud to play with water!\n"
                                                  + "My mom is going to kill me!",
                                                    "Thank you so much for fixing the water pump!\n"
                                                  + "I am never playing with water pumps again!");
        PointOfInterest colaMachine = new PointOfInterest("colamachine", 
                                                    "A cola vending machine\n"
                                                  + "One cola for a coin",
                                                    "You used the coin and got a cola");
        PointOfInterest store = new PointOfInterest("store",
                                                    "A grocery store. \n"
                                                  + "There is a line of shoppingcarts\n"
                                                  + "But they are all chained todether\n"
                                                  + "It says: insert a coin",
                                                    "The shopping carts are now unlocked\n");
        PointOfInterest oldMan = new PointOfInterest("oldman",
                                                    "Hello there, I have been living in the city all my life\n"
                                                  + "This city used be clean then I was young \n"
                                                  + "Now we produce and produce and produce....\n"
                                                  + "We polute and polute and polute...\n"
                                                  + "Especially that cola factory...",
                                                    "Thank you for helping me to get water");
        PointOfInterest door = new PointOfInterest("door",
                                                    "The backdoor into factory is locked",
                                                    "You used the keycart to unlock the door");
        PointOfInterest container = new PointOfInterest("container", 
                                                    "Garbage container,\n"
                                                  + " maybe there is something still usefull");
        PointOfInterest map = new PointOfInterest("map",
                                                    "map showing water requirements for producing 1 liter of cola ");

        // Lobby
        lobby.setExit("lake", lake);

        // Lake
        bridge.inventory.add(new Item("pipe", "A pipe", irrigation));
        lake.setPointOfInterest(boat);
        lake.setPointOfInterest(leakingpipe);
        lake.setPointOfInterest(bridge);

        lake.setExit("lobby", lobby);
        lake.setExit("bigcity", bigCity);
        lake.setExit("field", field);

        // Field
        farmhouse.inventory.add(new Item("rubberboots", "A pair of boots", boat));
        farmhouse.inventory.add(new Item("meatalpatch", "A metal patch", leakingpipe));
        irrigation.inventory.add(new Item("pumpHandle", "A pump handle", waterpump));
        field.setPointOfInterest(farmhouse);
        field.setPointOfInterest(irrigation);
        field.setPointOfInterest(pesticides);

        field.setExit("lake", lake);
        field.setExit("suburbs", suburbs);

        // Suburbs
        Item cola=new Item("cola","A bottle of cola",null);
        well.inventory.add(new Item("coin", "A golden coin", colaMachine,cola));
        suburbs.setPointOfInterest(waterpump);
        suburbs.setPointOfInterest(well);
        suburbs.setPointOfInterest(boy);
        suburbs.setExit("field", field);
        suburbs.setExit("bigcity", bigCity);
        

        // Big city
        store.inventory.add(new Item("cart", "A shopping cart", pesticides));
        bigCity.setPointOfInterest(colaMachine);
        bigCity.setPointOfInterest(store);
        bigCity.setPointOfInterest(oldMan);
        bigCity.setExit("lake", lake);
        bigCity.setExit("street", street);
        bigCity.setExit("suburbs", suburbs);

        // Street
        container.inventory.add(new Item("camera", "A digital camera", map));
        Item keycard=new Item("keycard", "A keycard opens a door", door);
        Item water=new Item("water","A bottle of water",oldMan,keycard);
        door.inventory.add(new Item("bottle","A bottle of water",well,water));
        street.setPointOfInterest(door);
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
       System.out.println("\n" +"\n" +
"                  /\\\n" +
"                /    \\\n" +
"              /        \\\n" +
"            /            \\\n" +
"          /                \\\n" +
"        /                    \\\n" +
"      /    __|_                \\\n" +
"    /     |[][]|____      ____   \\\n" +
"  /       |[][]|[][]|_[] |[][]|    \\ \n" +
" /    __[]|[][]|[][]|___\\|[][]|     \\ \n" +
" |   /__ _|[][]|[][]|[][]|[][]|      |\n" +
" |   |[][]|[][]|[][]|[][]|[][]|_[]   |\n" +
" |   |  /\\|/\\  |  /\\|  /\\|/\\  |___\\  |\n" +
" |   |[]|||||[]|[]|||[]|||||[]|[_]|  |\n" +
" |  ================================ |\n" +
" |        WELCOME TO LAST DROP       |\n" +
" \\  ================================ /\n" +
"  \\   ^       ^  ^   ^   ^    ^  ^  /\n" +
"   \\  ^   ^  ^   ^   ^^    ^   ^   /\n" +
"    \\  ^   ^  ^   ^    ^    ^  ^  /\n" +
"     \\___________________________/");
        System.out.println();
        System.out.println("An awesome adventure game that can help us to save water.");
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
            if(item.getIsSwitchable()==true&&item.usableAtPointOfInterest(currentPointOfInterest)==true){
                System.out.println("aha, a switchable!");
                currentPointOfInterest.inventory.add(item.getSwitcher());                   
            }
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
