package com.mycompany.rooms;

import com.mycompany.rooms.Rooms;
import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Waterpump;
import com.mycompany.pointsofinterest.Street;
import com.mycompany.pointsofinterest.Boy;

public class Suburbs extends Room {
    public Suburbs (Game game) {
        super(Rooms.SUBURBS);

        this.setPointOfInterest(new Waterpump());
        this.setPointOfInterest(new Street(game));
        this.setPointOfInterest(new Boy(game));
    }
}
