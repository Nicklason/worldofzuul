package worldofzuul;

import java.util.ArrayList;

public class PointOfInterest {
    private String name;
    private String description;
    public Inventory inventory;

    /**
     * PointOfInterest Constructor
     * @param name
     * @param description 
     */
    public PointOfInterest(String name, String description) {
        this.name = name;
        this.description = description;
        this.inventory = new Inventory();
    }

    /**
     * Get name
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Get description
     * @return 
     */
    public String getDescription() {
        return description;
    }

    public String getLongDescription () {
        return "You are " + description + ".\n" + getInventoryString();
    }

    public String getInventoryString () {
        String returnString = "Items:";

        ArrayList<Item> items = this.inventory.getAll();

        Integer itemCount = items.size();

        if (itemCount == 0) {
            returnString += " none";
        } else {
            for (int i = 0; i < itemCount; i++) {
                returnString += " " + items.get(i).getName();
            }
        }

        return returnString;
    }
}
