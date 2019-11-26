package com.mycompany.items;

import com.mycompany.items.Items;

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

        if (!game.getCurrentRoom().getName().equals("bigcity") || !pointOfInterest.getName().equals("oldman")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        Oldman oldman = new Oldman(game);
        oldman.setKeycardFalse();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println("Buying cola is exactly what is ruining our water supply!");
        this.game.inventory.remove(this);
    }
}
