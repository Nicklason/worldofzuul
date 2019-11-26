package com.mycompany.pointsofinterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.items.Coin;

public class Street extends PointOfInterest {
    public Street (Game game) {
        super("street", "You are standing at the street leading through the suburbs");

        this.inventory.add(new Coin(game));
    }
}
