package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointsOfInterest;
import com.mycompany.worldofzuul.Game;
import com.mycompany.items.Camera;

public class Container extends PointOfInterest {
    public Container (Game game) {
        super(PointsOfInterest.CONTAINER);

        this.inventory.add(new Camera(game));
    }
}
