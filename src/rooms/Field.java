package rooms;

import worldofzuul.Game;
import pointsofinterest.Farmhouse;
import pointsofinterest.Irrigation;
import pointsofinterest.Pesticides;

public class Field extends Room {
    public Field (Game game) {
        super("field", "At the field");

        this.setPointOfInterest(new Irrigation());
        this.setPointOfInterest(new Farmhouse(game));
        this.setPointOfInterest(new Pesticides(game));
    }
}
