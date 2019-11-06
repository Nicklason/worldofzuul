package rooms;

import worldofzuul.Game;
import pointsofinterest.Waterpump;
import pointsofinterest.Boy;

public class Street extends Room {
    public Street (Game game) {
        super("Street", "At the street");

        this.setPointOfInterest(new Waterpump());
        this.setPointOfInterest(new pointsofinterest.Street(game));
        this.setPointOfInterest(new Boy());
    }
}
