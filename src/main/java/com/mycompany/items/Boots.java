package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;

public class Boots extends Item {
    public Boots (Game game) {
        super(Items.BOOTS, game);
    }

    @Override
    public boolean usable () {
        return game.getCurrentRoom().getName().equals(Rooms.LAKE.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.BOAT.getName());
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
