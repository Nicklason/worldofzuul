package com.mycompany.rooms;

import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.rooms.Rooms;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Room {
    private Rooms room;
    private HashMap<String, Room> exits;
    private ArrayList<PointOfInterest> pointsOfInterest;

    public Room(Rooms room) {
        this.room = room;
        this.exits = new HashMap<String, Room>();
        this.pointsOfInterest = new ArrayList<PointOfInterest>();
    }

    public void setExit (Room neighbor)  {
        exits.put(neighbor.getName(), neighbor);
    }

    /**
     * Adds a point of interest to the room
     * @param pointOfInterest
     */
    public void setPointOfInterest (PointOfInterest pointOfInterest) {
        this.pointsOfInterest.add(pointOfInterest);
    }

    /**
     * Searches for a point of interest by name
     * @param name
     * @return Returns the match, or null if no match
     */
    public PointOfInterest getPointOfInterest (String name) {
        for (PointOfInterest pointOfInterest : this.pointsOfInterest) {
            if (pointOfInterest.getName().equals(name)) {
                return pointOfInterest;
            }
        }

        return null;
    }

    /**
     * Prints all points of interest
     */
    public void printAllPointsOfInterest () {
        System.out.print("Points of interest:");

        Integer pointCount = this.pointsOfInterest.size();

        if (pointCount == 0) {
            System.out.print(" none");
        } else {
            for (int i = 0; i < pointCount; i++) {
                System.out.print(" " + this.pointsOfInterest.get(i).getName());
            }
        }

        System.out.println();
    }

    public String getName() {
        return this.room.getName();
    }

    public boolean hasEndPicture () {
        return this.room.hasEndPicture();
    }

    public String getFixedPicturePath () {
        if (!hasEndPicture()) {
            return null;
        }

        return "images/rooms/" + this.room.getName() + "-fixed.png";
    }

    public String getNotFixedPicturePath () {
        if (!hasEndPicture()) {
            return null;
        }
        
        return "images/rooms/" + this.room.getName() + "-not-fixed.png";
    }

    public ArrayList<PointOfInterest> getPointsOfInterest(){
        return pointsOfInterest;
    }
    
    public Room getExit (String direction)  {
        return exits.get(direction);
    }
}
