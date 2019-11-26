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
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals(Rooms.BIGCITY.getName()) || !pointOfInterest.getName().equals(PointsOfInterest.OLDMAN.getName()) && !pointOfInterest.isFixed()) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        Oldman oldman = (Oldman)this.game.getCurrentPointOfInterest();
        if (oldman.getKeycard()) {
            pointOfInterest.inventory.add(new Keycard(game));
        }

        pointOfInterest.setFixed();
        System.out.println("Giving " + this.getName() + " to " + pointOfInterest.getName());
        
        
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
        
    }
}
