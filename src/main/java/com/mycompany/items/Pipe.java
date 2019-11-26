package com.mycompany.items;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;;

public class Pipe extends Item {
    public Pipe (Game game) {
        super("pipe", "A pipe", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("field") || !pointOfInterest.getName().equals("irrigation")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
    }
}
