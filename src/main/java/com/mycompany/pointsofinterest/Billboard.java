package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.items.EmptyBottle;
import com.mycompany.worldofzuul.Game;

public class Billboard extends PointOfInterest {
    public Billboard (Game game) {
        super(PointsOfInterest.BILLBOARD);
        this.inventory.add(new EmptyBottle(game));
    }
}
