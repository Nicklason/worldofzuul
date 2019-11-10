package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;
import rooms.Factory;
import rooms.Room;

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
        Room street = game.getRoom("street");

        street.setExit(factory);
        factory.setExit(street);

        System.out.println("New exit factory added");
    }
}