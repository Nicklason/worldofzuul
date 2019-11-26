package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.items.Pumphandle;
import com.mycompany.worldofzuul.Game;

public class Boy extends PointOfInterest {
    public Boy (Game game) {
        super(PointsOfInterest.BOY);
        this.inventory.add(new Pumphandle(game));
    }
}
