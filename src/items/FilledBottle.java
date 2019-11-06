/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import worldofzuul.Game;

/**
 *
 * @author Nica
 */
import worldofzuul.Game;
import pointsofinterest.PointOfInterest;;

public class FilledBottle extends Item {
    public FilledBottle (Game game) {
        super("filledbottle", "A full bottle", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("bigcity") || !pointOfInterest.getName().equals("oldman") && !pointOfInterest.isFixed()) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }
        
        pointOfInterest.setFixed();

        System.out.println("Giving " + this.getName() + " to " + pointOfInterest.getName());
        pointOfInterest.inventory.add(new Keycard(game));
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
        
    }
}
