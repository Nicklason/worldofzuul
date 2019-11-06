package pointsofinterest;

import worldofzuul.Game;
import items.Coin;

public class StreetPoi extends PointOfInterest {
    public StreetPoi (Game game) {
        super("street", "You are standing at the street leading through the suburbs");

        this.inventory.add(new Coin(game));
    }
}
