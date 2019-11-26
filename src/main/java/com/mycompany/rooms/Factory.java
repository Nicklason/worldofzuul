package com.mycompany.rooms;

import com.mycompany.rooms.Rooms;
import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Map;

public class Factory extends Room {
    public Factory (Game game) {
        super(Rooms.FACTORY);

        this.setPointOfInterest(new Map(game));
    }
}