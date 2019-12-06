package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;

public class EmptyBottle extends Item {
    public EmptyBottle (Game game) {
        super(Items.EMPTYBOTTLE, game);
    }

    @Override
    public boolean usable () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        return game.getCurrentRoom().getName().equals(Rooms.SUBURBS.getName()) && pointOfInterest.getName().equals(PointsOfInterest.WATERPUMP.getName()) && pointOfInterest.isFixed();
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }
        
        this.game.inventory.remove(this);
        this.game.inventory.add(new FilledBottle(game));

        return true;
    }
}