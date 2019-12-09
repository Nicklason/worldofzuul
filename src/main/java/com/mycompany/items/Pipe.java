package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;

public class Pipe extends Item {
    public Pipe (Game game) {
        super(Items.PIPE, game);
    }

    @Override
    public boolean usable () {
        return game.getCurrentRoom().getName().equals(Rooms.FIELD.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.IRRIGATION.getName());
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
