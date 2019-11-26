package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.pointsofinterest.Oldman;
import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;

public class Cola extends Item {
    public Cola (Game game) {
        super(Items.COLA, game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals(Rooms.BIGCITY.getName()) || !pointOfInterest.getName().equals(PointsOfInterest.OLDMAN.getName())) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        Oldman oldman = (Oldman)pointOfInterest;
        oldman.setKeycardFalse();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println("Buying cola is exactly what is ruining our water supply!");
        this.game.inventory.remove(this);
    }
}
