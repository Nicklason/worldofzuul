package pointsofinterest;

import items.Pipe;
import worldofzuul.Game;

public class Bridge extends PointOfInterest {
    public Bridge (Game game) {
        super("bridge", "A small bridge is falling apart, maybe there is something useful?");
        this.inventory.add(new Pipe(game));
    }
}
