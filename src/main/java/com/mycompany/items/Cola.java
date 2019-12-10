package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.pointsofinterest.Oldman;
import com.mycompany.worldofzuul.Game;

public class Cola extends Item {
    public Cola (Game game) {
        super(Items.COLA, game);
    }

    @Override
    public boolean usable () {
        return game.getCurrentRoom().getName().equals(Rooms.BIGCITY.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.OLDMAN.getName());
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }

        Oldman oldman = (Oldman)game.getCurrentPointOfInterest();
        oldman.setKeycardFalse();
        
        oldman.setDescription("Oldman: I don't want your cola, this is what is ruining our city!");

        this.game.inventory.remove(this);

        return true;
    }
}
