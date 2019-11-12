package items;

import pointsofinterest.Oldman;
import worldofzuul.Game;
import pointsofinterest.PointOfInterest;

public class Cola extends Item {
    public Cola (Game game) {
        super("cola", "A can of cola", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("bigcity") || !pointOfInterest.getName().equals("oldman")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        Oldman oldman = new Oldman(game);
        oldman.setKeycardFalse();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println("Buying cola is exactly what is ruining our water supply!");
        this.game.inventory.remove(this);
    }
}
