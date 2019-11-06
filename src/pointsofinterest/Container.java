package pointsofinterest;

import worldofzuul.Game;
import items.Camera;

public class Container extends PointOfInterest {
    public Container (Game game) {
        super("container", "Garbage container, maybe there is something useful");

        this.inventory.add(new Camera(game));
    }
}