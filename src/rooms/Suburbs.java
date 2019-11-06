package rooms;

import worldofzuul.Game;
import pointsofinterest.Waterpump;
import pointsofinterest.StreetPoi;
import pointsofinterest.Boy;

public class Suburbs extends Room {
    public Suburbs (Game game) {
        super("suburbs", "In the suburban neighbourhood");

        this.setPointOfInterest(new Waterpump());
        this.setPointOfInterest(new StreetPoi(game));
        this.setPointOfInterest(new Boy());
    }
}
