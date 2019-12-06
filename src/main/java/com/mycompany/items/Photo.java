package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;

public class Photo extends Item {
    public Photo (Game game) {
        super(Items.PHOTO, game);
    }

    @Override
    public boolean usable () {
        return game.getCurrentRoom().getName().equals(Rooms.STREET.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.BILLBOARD.getName());
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
