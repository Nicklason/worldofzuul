package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;

public class Metalpatch extends Item {
    public Metalpatch (Game game) {
        super(Items.METALPATCH, game);
    }

    @Override
    public boolean usable() {
        return game.getCurrentRoom().getName().equals(Rooms.LAKE.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.LEAKINGPIPE.getName());
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }

        game.getCurrentPointOfInterest().setFixed();

        this.game.inventory.remove(this);

        return true;
    }
}