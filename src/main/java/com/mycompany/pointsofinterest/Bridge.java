package com.mycompany.pointsofinterest;

import com.mycompany.items.Pipe;
import com.mycompany.worldofzuul.Game;

public class Bridge extends PointOfInterest {
    public Bridge (Game game) {
        super("bridge", "A small bridge is falling apart, maybe there is something useful?");
        this.inventory.add(new Pipe(game));
    }
}
