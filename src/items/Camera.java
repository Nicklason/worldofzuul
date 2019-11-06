package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;;

public class Camera extends Item {
    public Camera (Game game) {
        super("camera", "A digital camera", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        // If the poi is already fixed, then don't allow the item to be used (it would keep adding " (with photo)" to the name)
        if (!game.getCurrentRoom().getName().equals("factory") || !pointOfInterest.getName().equals("map") || pointOfInterest.isFixed()) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());

        pointOfInterest.setFixed();

        // The item now contains a photo
        this.name += " (with photo)";
    }
}
