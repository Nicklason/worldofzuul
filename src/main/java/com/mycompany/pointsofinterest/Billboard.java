package com.mycompany.pointsofinterest;

import com.mycompany.items.EmptyBottle;
import com.mycompany.worldofzuul.Game;

public class Billboard extends PointOfInterest {
    public Billboard (Game game) {
        super("billboard", "A billboard, can be used to show a photo", "Your photo is now being viewed by many people, hopefully they change their minds now");
        this.inventory.add(new EmptyBottle(game));
    }
    
    
}
