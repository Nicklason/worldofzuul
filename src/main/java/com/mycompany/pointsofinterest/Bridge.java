package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointsOfInterest;
import com.mycompany.items.Pipe;
import com.mycompany.worldofzuul.Game;

public class Bridge extends PointOfInterest {
    public Bridge (Game game) {
        super(PointsOfInterest.BRIDGE);
        this.inventory.add(new Pipe(game));
    }
}
