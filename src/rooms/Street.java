package rooms;

import worldofzuul.Game;
import pointsofinterest.Container;
import pointsofinterest.LockedDoor;

public class Street extends Room {
    public Street (Game game) {
        super("street", "In the street");

        this.setPointOfInterest(new Container(game));
        this.setPointOfInterest(new LockedDoor());
    }
}
