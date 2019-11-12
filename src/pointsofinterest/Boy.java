package pointsofinterest;

import items.Metalpatch;
import items.Pumphandle;
import worldofzuul.Game;
import pointsofinterest.Waterpump;

public class Boy extends PointOfInterest {
    public Boy (Game game) {
        super("boy", "Oh no, I have been playing with the waterpump and the handle came off! My mom's going to kill me!", "Thank you, I'll never play with water again.");
        this.inventory.add(new Pumphandle(game));
    }  
  }


