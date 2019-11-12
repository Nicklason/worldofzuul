package items;

import worldofzuul.Game;

import pointsofinterest.PointOfInterest;
import pointsofinterest.Oldman;

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

        Oldman oldman = (Oldman)this.game.getRoom("bigcity").getPointOfInterest("oldman");
        if (oldman.getKeycard()) {
            pointOfInterest.inventory.add(new Keycard(game));
        }

        pointOfInterest.setFixed();
        System.out.println("Giving " + this.getName() + " to " + pointOfInterest.getName());
        
        
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
        
    }
}
