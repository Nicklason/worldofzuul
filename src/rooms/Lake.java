package rooms;

import worldofzuul.Game;
import pointsofinterest.Boat;

public class Lake extends Room {
    public Lake (Game game) {
        super("lake", "At the lake");

        this.setPointOfInterest(new Boat(game));
    }
}
