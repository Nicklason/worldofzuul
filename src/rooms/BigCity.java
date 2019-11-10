package rooms;

import worldofzuul.Game;
import pointsofinterest.Store;
import pointsofinterest.Vendingmachine;
import pointsofinterest.Oldman;

public class BigCity extends Room {
    public BigCity (Game game) {
        super("bigcity", "in the bigcity");

        this.setPointOfInterest(new Vendingmachine());
        this.setPointOfInterest(new Store());
        this.setPointOfInterest(new Oldman(game));
    }
}