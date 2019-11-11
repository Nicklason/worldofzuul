package worldofzuul;

import items.Item;

import java.util.ArrayList;

/**
 * Inventory class
 */
public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();
    private Integer limit;

    public Inventory () {
        this.limit = -1;
    }

    public Inventory (Integer limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("Inventory limit can't be less than 1");
        }

        this.limit = limit;
    }

    /**
     * Adds an item to the inventory
     * @param item
     * @return Returns true if it was added, false if not
     */
    public Boolean add (Item item) {
        if (this.limit == -1 || this.limit > this.items.size()) {
            items.add(item);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a specific item from the inventory
     * @param item
     */
    public void remove (Item item) {
        for (int i = 0; i < items.size(); i++) {
            // Look for the exact same item (same address in memory)
            if (items.get(i) == item) {
                // Found a match, remove it
                items.remove(i);
                return;
            }
        }
    }

    /**
     * Gets an item from the inventory by name
     * @param name
     * @return Returns null if an item was not found
     */
    public Item get (String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }

        return null;
    }

    /**
     * Returns all items from the inventory
     * @return items
     */
    public ArrayList<Item> getAll () {
        return items;
    }

    /**
     * Returns a string of item names / none if inventory is empty
     * @return
     */
    public String getItemsString () {
        Integer itemCount = items.size();

        String returnString = "";

        if (itemCount == 0) {
            returnString += "none";
        } else {
            for (int i = 0; i < itemCount; i++) {
                if (i != 0) {
                    returnString += " ";
                }
                returnString += items.get(i).getName();
            }
        }

        return returnString;
    }
}
