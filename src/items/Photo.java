package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;

public class Photo extends Item {
    public Photo (Game game) {
        super("photo", "A photo of the secret behind the production of cola", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("street") || !pointOfInterest.getName().equals("billboard")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);
    }
}
