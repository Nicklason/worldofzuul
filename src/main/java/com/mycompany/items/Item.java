package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.worldofzuul.Game;

public abstract class Item {
    private Items item;
    protected Game game;

    /**
     * constructs an item object using 2 strings as parameters
     * @param name
     * @param description
     * @param game Reference to the game
     */
    public Item (Items item, Game game) {
        this.item = item;
        this.game = game;
    }

    /**
     * Retunere name
     * @return name
     */
    public String getName() {
        return item.getName();
    }

    /**
     * Retunere Description
     * @return description 
     */
    public String getDescription() {
        return item.getDescription();
    }
    
    /**
     * Returns image path
     * @return
     */
    public String getImagePath() {
        return item.getImagePath();
    }

    /**
     * Function for using the item, returns true or false if it was used or not
     * @return
     */
    public abstract boolean use();

    /**
     * Checks if the item is usable with the current room and poi
     * @return
     */
    public abstract boolean usable();
}
