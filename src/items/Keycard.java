/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

/**
 *
 * @author Nica
 */
import worldofzuul.Game;
import pointsofinterest.PointOfInterest;
import rooms.Factory;
;

public class Keycard extends Item {
    public Keycard (Game game) {
        super("keycard", "A keycard", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("street") || !pointOfInterest.getName().equals("lockeddoor")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
        Factory factory = new Factory(game);
        game.getRoom("street").setExit(factory);
        factory.setExit(game.getRoom("street"));
        System.out.println("New exit factory added");
        
        
    }
}