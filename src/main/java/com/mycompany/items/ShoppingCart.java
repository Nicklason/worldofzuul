package com.mycompany.items;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;

public class ShoppingCart extends Item {
    public ShoppingCart (Game game) {
        super("shoppingcart", "A shopping cart", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("field") || !pointOfInterest.getName().equals("pesticides")) {
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
