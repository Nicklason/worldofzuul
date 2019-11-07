package pointsofinterest;

import items.Boots;
import items.Metalpatch;
import worldofzuul.Game;

public class Farmhouse extends PointOfInterest {
    public Farmhouse (Game game) {
        super("farmhouse", "An abandoned farmhouse, maybe something usefull");
    
        this.inventory.add(new Metalpatch(game));
        this.inventory.add(new Boots(game));
    }
}