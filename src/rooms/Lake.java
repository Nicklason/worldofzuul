package rooms;

import worldofzuul.Game;
import pointsofinterest.Boat;
import pointsofinterest.LeakingPipe;
import pointsofinterest.Bridge;

public class Lake extends Room {
    public Lake (Game game) {
        super("lake", "At the lake");

        this.setPointOfInterest(new Boat(game));
        this.setPointOfInterest(new LeakingPipe());
        this.setPointOfInterest(new Bridge(game));
    }
}
