package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointsOfInterest;
import com.mycompany.items.Boots;
import com.mycompany.items.Metalpatch;
import com.mycompany.worldofzuul.Game;

public class Farmhouse extends PointOfInterest {
    public Farmhouse (Game game) {
        super(PointsOfInterest.FARMHOUSE);
    
        this.inventory.add(new Metalpatch(game));
        this.inventory.add(new Boots(game));
    }
}