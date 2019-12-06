package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.pointsofinterest.Oldman;

public class FilledBottle extends Item {
    public FilledBottle (Game game) {
        super(Items.FILLEDBOTTLE, game);
    }

    @Override
    public boolean usable () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        return game.getCurrentRoom().getName().equals(Rooms.BIGCITY.getName()) && pointOfInterest.getName().equals(PointsOfInterest.OLDMAN.getName()) && !pointOfInterest.isFixed();
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }

        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        Oldman oldman = (Oldman)pointOfInterest;
        if (oldman.getKeycard()) {
            pointOfInterest.inventory.add(new Keycard(game));
        }

        pointOfInterest.setFixed();

        this.game.inventory.remove(this);
        
        return true;
    }
}
