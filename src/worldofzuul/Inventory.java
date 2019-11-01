package worldofzuul;

import java.util.ArrayList;

/**
 * Inventory class
 */
public class Inventory {
    private ArrayList<Item> items;

    /**
     * Adds an item to the inventory
     * @param item
     * @return Returns true if it was added, false if not
     */
    public Boolean add (Item item) {
        items.add(item);
        return true;
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
            if (item.getName() == name) {
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
}
