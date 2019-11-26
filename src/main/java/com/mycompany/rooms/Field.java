package com.mycompany.rooms;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Farmhouse;
import com.mycompany.pointsofinterest.Irrigation;
import com.mycompany.pointsofinterest.Pesticides;

public class Field extends Room {
    public Field (Game game) {
        super("field", "At the field");

        this.setPointOfInterest(new Irrigation());
        this.setPointOfInterest(new Farmhouse(game));
        this.setPointOfInterest(new Pesticides(game));
    }
}
