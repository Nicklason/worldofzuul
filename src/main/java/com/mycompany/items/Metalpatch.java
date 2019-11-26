package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;;

public class Metalpatch extends Item {
    public Metalpatch (Game game) {
        super(Items.METALPATCH, game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals(Rooms.LAKE.getName()) || !pointOfInterest.getName().equals(PointsOfInterest.LEAKINGPIPE.getName())) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
    }
}