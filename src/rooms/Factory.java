package rooms;

import worldofzuul.Game;
import pointsofinterest.Map;

public class Factory extends Room {
    public Factory (Game game) {
        super("factory", "At the factory");

        this.setPointOfInterest(new Map(game));
    }
}