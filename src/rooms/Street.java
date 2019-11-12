package rooms;

import worldofzuul.Game;
import pointsofinterest.Billboard;
import pointsofinterest.Container;
import pointsofinterest.LockedDoor;

public class Street extends Room {
    public Street (Game game) {
        super("street", "In the street");

        this.setPointOfInterest(new Billboard());
        this.setPointOfInterest(new Container(game));
        this.setPointOfInterest(new LockedDoor());
    }
}
