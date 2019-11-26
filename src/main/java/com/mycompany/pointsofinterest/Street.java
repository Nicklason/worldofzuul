package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointsOfInterest;
import com.mycompany.worldofzuul.Game;
import com.mycompany.items.Coin;

public class Street extends PointOfInterest {
    public Street (Game game) {
        super(PointsOfInterest.STREET);

        this.inventory.add(new Coin(game));
    }
}
