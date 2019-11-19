package worldofzuul;

import items.*;
import pointsofinterest.*;
import rooms.*;
import rooms.Street;

import java.util.ArrayList;

public class Game {

    private Parser parser;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    public Inventory inventory;
    public ArrayList<Room> rooms;

    public Game() {
        this.rooms = new ArrayList<Room>();
        this.inventory = new Inventory();
        createRooms();
        parser = new Parser();

    }

    private void createRooms() {
        // Rooms
        Lobby lobby = new Lobby();
        Lake lake = new Lake(this);
        Field field = new Field(this);
        BigCity bigcity = new BigCity(this);
        Suburbs suburbs = new Suburbs(this);
        Street street = new Street(this);

        rooms.add(lake);
        rooms.add(field);
        rooms.add(bigcity);
        rooms.add(suburbs);
        rooms.add(street);

        // Exits
        lobby.setExit(lake);

        lake.setExit(field);
        lake.setExit(bigcity);
        lake.setExit(lobby);

        field.setExit(lake);
        field.setExit(suburbs);

        bigcity.setExit(lake);
        bigcity.setExit(suburbs);
        bigcity.setExit(street);

        suburbs.setExit(field);
        suburbs.setExit(bigcity);

        street.setExit(bigcity);

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
        System.out.println();
        System.out.println("You are at standing on the edge of a huge water dam.");
        System.out.println("You see a young girl next to you looking down into the water.");
        System.out.println("She looks at you and says Hello");
        System.out.println("Hello, my name is Clair.");
        System.out.println("I used to come to the dam since I was a little girl"); 
        System.out.println("Back then, there was blue water all up to the edge"); 
        System.out.println("Now it is all dark and poluted..."); 
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
            
            wantToQuit = finish();
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
            System.out.println("Thats not an exit");
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
            System.out.println("The " + item.getName() + " has been added to your inventory");
        } else {
            System.out.println("You can't carry more items!");
        }
    }

    private void dropItem(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }

        if (this.currentPointOfInterest == null) {
            System.out.println("You are not investigating a point of interest");
            return;
        }

        String itemName = command.getSecondWord();

        Item item = this.inventory.get(itemName);

        if (item == null) {
            System.out.println("Could not find the item");
            return;
        }
 
        this.inventory.remove(item);
        System.out.println("The item has been removed from your inventory");
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

    private boolean finish() {
        
        if (!currentRoom.getName().equals("lobby")) {
            System.out.println("If you're done you should go speak to Clair");
            return false;
        }
        
        int totalFixedCount = 0;
        for (Room room : rooms) {
            int fixedCount = 0;
            int fixableCount = 0;
            for (PointOfInterest poi : room.getPointsOfInterest()) {
                if (poi.isFixed() && poi.isFixable()) {
                    fixedCount++;
                    totalFixedCount++;
                }
                if (poi.isFixable()) {
                    fixableCount++;
                }
            }
            System.out.println(room.getName());
            System.out.println(fixedCount + "/" + fixableCount + " completed");
        }
        System.out.println("Highscore: " + (totalFixedCount * 100) + " you fixed " + totalFixedCount + " objectives");
        return true;
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

    /**
     * Get a room by name
     *
     * @param name
     * @return
     */
    public Room getRoom(String name) {
        for (Room room : rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }

        return null;
    }

    public PointOfInterest getCurrentPointOfInterest() {
        return currentPointOfInterest;
    }
}
