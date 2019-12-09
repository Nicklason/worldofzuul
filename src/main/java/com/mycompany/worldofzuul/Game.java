package com.mycompany.worldofzuul;

import com.mycompany.pointsofinterest.*;
import com.mycompany.rooms.*;
import com.mycompany.rooms.Street;

import java.util.ArrayList;

public class Game {

    private Room currentRoom;
    private PointOfInterest currentPointOfInterest;
    public Inventory inventory;
    public ArrayList<Room> rooms;
    public int fixedCount = 0;
    public double progress = 0;
    private static Game single_instance = null;

    public Game() {
        this.rooms = new ArrayList<Room>();
        this.inventory = new Inventory();
        createRooms();
        System.err.println("New instance of game has been made");
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

    public ArrayList<String> createEndList() {
        // arraylist
        ArrayList<String> picturepaths = new ArrayList<>();
        for (Room room : rooms) {
            int count = 0;
            double maxcount = 0;
            for (PointOfInterest pointofinterest : room.getPointsOfInterest()) {

                if (pointofinterest.isFixable()) {
                    maxcount++;

                    if (pointofinterest.isFixed()) {
                        count++;

                    }
                }

            }
            if (room.getName().equals(Rooms.LAKE.getName())) {

                if (count >= (maxcount / 100) * 66) {
                    System.out.println(maxcount + "c");
                    picturepaths.add("images/rooms/2 lakefixed.png");

                } else {
                    picturepaths.add("images/rooms/2 lakenotfixed.png");
                }
            }

            if (room.getName().equals(Rooms.FIELD.getName())) {

                if (count >= (maxcount / 100) * 66) {
                    picturepaths.add("images/rooms/3 fieldfixed.png");

                } else {
                    picturepaths.add("images/rooms/3 fieldnotfixed.png");
                }
            }
            if (room.getName().equals(Rooms.SUBURBS.getName())) {
                if (count >= (maxcount / 100) * 66) {
                    picturepaths.add("images/rooms/4 suburbsfixed.png");

                } else {
                    picturepaths.add("images/rooms/4 suburbsnotfixed.png");
                }
            }
            if (room.getName().equals(Rooms.BIGCITY.getName())) {
                if (count >= (maxcount / 100) * 66) {
                    picturepaths.add("images/rooms/5 bigcityfixed.png");

                } else {
                    picturepaths.add("images/rooms/5 bigcitynotfixed.png");
                }
            }
            if (room.getName().equals(Rooms.STREET.getName())) {
                if (count >= (maxcount / 100) * 66) {
                    picturepaths.add("images/rooms/6 street.png");

                } else {
                    picturepaths.add("images/rooms/6 street.png");
                }
            }
            if (room.getName().equals(Rooms.FACTORY.getName())) {
                if (count >= (maxcount / 100) * 66) {
                    picturepaths.add("images/rooms/7 factory.png");

                } else {
                    picturepaths.add("images/rooms/7 factory.png");
                }
            }

        }

        return picturepaths;

    }

}
