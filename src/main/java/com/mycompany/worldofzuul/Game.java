package com.mycompany.worldofzuul;

import com.mycompany.pointsofinterest.*;
import com.mycompany.rooms.*;
import com.mycompany.rooms.Street;

import java.util.ArrayList;

public class Game {

    private GameState state;
    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    public Inventory inventory;
    public ArrayList<Room> rooms;
    public int fixedCount = 0;
    public double progress = 0;
    private static Game single_instance = null;

    public static enum GameState {
        INTRO,
        PLAYING,
        IN_LOBBY,
        FINISHED
    };

    public Game() {
        this.state = GameState.INTRO;
        this.rooms = new ArrayList<Room>();
        this.inventory = new Inventory(2);
        createRooms();
        System.err.println("New instance of game has been made");
    }

    public void setState (GameState state) {
        this.state = state;
    }

    public GameState getState () {
        return this.state;
    }

    public static Game getInstance() {
        if (single_instance == null) {
            single_instance = new Game();
        }

        return single_instance;
    }

    private void createRooms() {
        // Rooms
        Lobby lobby = new Lobby();
        Lake lake = new Lake(this);
        Field field = new Field(this);
        BigCity bigcity = new BigCity(this);
        Suburbs suburbs = new Suburbs(this);
        Street street = new Street(this);
        Factory factory = new Factory(this);

        rooms.add(lake);
        rooms.add(field);
        rooms.add(bigcity);
        rooms.add(suburbs);
        rooms.add(street);
        rooms.add(factory);

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

    public void setCurrentPointOfInterest(PointOfInterest poi) {
        this.currentPointOfInterest = poi;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public PointOfInterest getCurrentPointOfInterest() {
        return currentPointOfInterest;
    }

    public ArrayList<String> getEndPictures() {
        ArrayList<String> picturePaths = new ArrayList<>();

        for (Room room: rooms) {
            if (!room.hasEndPicture()) {
                continue;
            }

            int count = 0;
            int maxCount = 0;

            for (PointOfInterest pointofinterest: room.getPointsOfInterest()) {
                if (pointofinterest.isFixable()) {
                    maxCount++;

                    if (pointofinterest.isFixed()) {
                        count++;
                    }
                }
            }

            System.out.println(room.getName() + " " + count / (double)maxCount);

            if (count / (double)maxCount >= 0.66) {
                picturePaths.add(room.getFixedPicturePath());
            } else {
                picturePaths.add(room.getNotFixedPicturePath());
            }
        }

        return picturePaths;
    }
}
