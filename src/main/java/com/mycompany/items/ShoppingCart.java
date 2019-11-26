package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;

public class ShoppingCart extends Item {
    public ShoppingCart (Game game) {
        super(Items.SHOPPINGCART, game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals(Rooms.FIELD.getName()) || !pointOfInterest.getName().equals(PointsOfInterest.PESTICIDES.getName())) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());

        this.game.inventory.remove(this);

        // FIXME: Should we pick up the pesticides, or should it just be removed?
    }
}
