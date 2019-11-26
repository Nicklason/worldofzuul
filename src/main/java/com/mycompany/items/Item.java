package com.mycompany.items;

import com.mycompany.worldofzuul.Game;

public abstract class Item {
    protected String name;
    private String description;
    protected Game game;

    /**
     * constructs an item object using 2 strings as parameters
     * @param name
     * @param description
     * @param game Reference to the game
     */
    public Item (String name, String description, Game game) {
        this.name = name;
        this.description = description;
        this.game = game;
    }

    /**
     * Retunere name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Retunere Description
     * @return description 
     */
    public String getDescription() {
        return description;
    }

    public abstract void use();
}
