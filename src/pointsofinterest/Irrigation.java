package pointsofinterest;

import worldofzuul.Game;
import items.Pumphandle;

public class Irrigation extends PointOfInterest {
    public Irrigation (Game game) {
        super("irrigation", "The irrigation system is missing a pipe, water is running out on the ground", "You hav fixed the irrigation system, water is not getting wasted anymore.");
    }
}
