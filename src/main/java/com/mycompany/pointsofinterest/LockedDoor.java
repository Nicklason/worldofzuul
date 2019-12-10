package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointsOfInterest;
import com.mycompany.items.EmptyBottle;
import com.mycompany.worldofzuul.Game;

public class LockedDoor extends PointOfInterest {
    public LockedDoor (Game game) {
        super(PointsOfInterest.LOCKEDDOOR);
        this.inventory.add(new EmptyBottle(game));
    }
}
