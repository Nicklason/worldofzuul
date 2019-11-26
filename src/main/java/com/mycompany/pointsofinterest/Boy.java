package com.mycompany.pointsofinterest;

import com.mycompany.items.Pumphandle;
import com.mycompany.worldofzuul.Game;

public class Boy extends PointOfInterest {
    public Boy (Game game) {
        super("boy", "Oh no, I have been playing with the waterpump and the handle came off! My mom's going to kill me!");
        this.inventory.add(new Pumphandle(game));
    }
}
