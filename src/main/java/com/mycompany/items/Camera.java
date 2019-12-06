package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.items.Photo;

public class Camera extends Item {
    public Camera (Game game) {
        super(Items.CAMERA, game);
    }

    @Override
    public boolean usable () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        return game.getCurrentRoom().getName().equals(Rooms.FACTORY.getName()) && pointOfInterest.getName().equals(PointsOfInterest.MAP.getName());
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }

        game.getCurrentPointOfInterest().setFixed();

        this.game.inventory.remove(this);
        this.game.inventory.add(new Photo(game));

        return true;
    }
}
