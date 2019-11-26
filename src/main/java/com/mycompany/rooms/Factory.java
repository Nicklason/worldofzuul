package com.mycompany.rooms;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Map;

public class Factory extends Room {
    public Factory (Game game) {
        super("factory", "At the factory");

        this.setPointOfInterest(new Map(game));
    }
}