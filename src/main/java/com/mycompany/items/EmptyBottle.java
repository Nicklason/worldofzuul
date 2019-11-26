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
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals(Rooms.SUBURBS.getName()) || !pointOfInterest.getName().equals(PointsOfInterest.WATERPUMP.getName()) || !pointOfInterest.isFixed()) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
        System.out.println("Filled waterbottle added to inventory");
        this.game.inventory.add(new FilledBottle(game));
    }
}