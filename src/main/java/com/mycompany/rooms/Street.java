package com.mycompany.rooms;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Billboard;
import com.mycompany.pointsofinterest.Container;
import com.mycompany.pointsofinterest.LockedDoor;

public class Street extends Room {
    public Street (Game game) {
        super("street", "In the street");

        this.setPointOfInterest(new Billboard(game));
        this.setPointOfInterest(new Container(game));
        this.setPointOfInterest(new LockedDoor());
    }
}
