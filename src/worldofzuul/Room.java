package worldofzuul;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<PointOfInterest> pointsOfInterest;
    private String name;

    public Room(String name, String description) 
    {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<String, Room>();
        this.pointsOfInterest = new ArrayList<PointOfInterest>();
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
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
            if (pointOfInterest.getName() == name) {
                return pointOfInterest;
            }
        }

        return null;
    }

    /**
     * Prints all points of interest
     */
    public void printAllPointsOfInterest () {
        System.out.print("Points of interest: ");

        Integer pointCount = this.pointsOfInterest.size();

        for (int i = 0; i < pointCount; i++) {
            System.out.print(this.pointsOfInterest.get(i).getName());
            if (i != pointCount - 1) {
                System.out.print(", ");
            }
        }
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    public String getName() {
        return name;
    }
}
