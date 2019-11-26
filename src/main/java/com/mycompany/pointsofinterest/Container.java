package com.mycompany.pointsofinterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.items.Camera;

public class Container extends PointOfInterest {
    public Container (Game game) {
        super("container", "Garbage container, maybe there is something useful");

        this.inventory.add(new Camera(game));
    }
}
