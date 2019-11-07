package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;;

public class Metalpatch extends Item {
    public Metalpatch (Game game) {
        super("metalpatch", "A metalpatch", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("lake") || !pointOfInterest.getName().equals("leakingpipe")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
    }
}