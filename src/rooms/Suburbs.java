package rooms;

import worldofzuul.Game;
import pointsofinterest.Waterpump;
import pointsofinterest.Street;
import pointsofinterest.Boy;

public class Suburbs extends Room {
    public Suburbs (Game game) {
        super("suburbs", "In the suburban neighbourhood");

        this.setPointOfInterest(new Waterpump());
        this.setPointOfInterest(new Street(game));
        this.setPointOfInterest(new Boy(game));
    }
}
