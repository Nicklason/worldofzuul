package com.mycompany.rooms;

import com.mycompany.rooms.Rooms;
import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Store;
import com.mycompany.pointsofinterest.Vendingmachine;
import com.mycompany.pointsofinterest.Oldman;

public class BigCity extends Room {
    public BigCity (Game game) {
        super(Rooms.BIGCITY);

        this.setPointOfInterest(new Vendingmachine());
        this.setPointOfInterest(new Store());
        this.setPointOfInterest(new Oldman(game));
    }
}