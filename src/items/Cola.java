package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;

public class Cola extends Item {
    public Cola (Game game) {
        super("cola", "A can of cola", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("street") || !pointOfInterest.getName().equals("boy")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());

        this.game.inventory.remove(this);
    }
}
