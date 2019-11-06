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
import pointsofinterest.PointOfInterest;;

public class EmptyBottle extends Item {
    public EmptyBottle (Game game) {
        super("emptybottle", "A empty bottle", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("suburbs") || !pointOfInterest.getName().equals("waterpump") || !pointOfInterest.isFixed()) {
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