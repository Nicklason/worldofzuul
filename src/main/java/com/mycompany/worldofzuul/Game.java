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

    public Game() {
        this.rooms = new ArrayList<Room>();
        this.inventory = new Inventory();
        createRooms();
        System.err.println("New instance of game has been made");
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
    
    public void setCurrentPointOfInterest(PointOfInterest poi){
        this.currentPointOfInterest = poi;
    }
    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }
    
    public PointOfInterest getCurrentPointOfInterest() {
        return currentPointOfInterest;
    }
}
