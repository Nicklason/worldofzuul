package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;

public class Boots extends Item {
    public Boots (Game game) {
        super("boots", "A pair of boots", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("lake") || !pointOfInterest.getName().equals("boat")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
    }
}
