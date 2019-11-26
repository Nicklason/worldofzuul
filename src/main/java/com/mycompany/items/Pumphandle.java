package com.mycompany.items;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;

public class Pumphandle extends Item {

    public Pumphandle(Game game) {
        super("pumphandle", "A pumphandle", game);
    }

    @Override
    public void use() {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();
        if (!game.getCurrentRoom().getName().equals("suburbs") || !pointOfInterest.getName().equals("waterpump")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        game.getCurrentRoom().getPointOfInterest("boy").setDescription("Thank you for fixing the pump, I will never play with water again!");
                
        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());

        this.game.inventory.remove(this);
    }
}
