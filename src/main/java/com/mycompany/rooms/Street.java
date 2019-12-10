package com.mycompany.rooms;

import com.mycompany.rooms.Rooms;
import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Billboard;
import com.mycompany.pointsofinterest.Container;
import com.mycompany.pointsofinterest.LockedDoor;

public class Street extends Room {
    public Street (Game game) {
        super(Rooms.STREET);

        this.setPointOfInterest(new Billboard());
        this.setPointOfInterest(new Container(game));
        this.setPointOfInterest(new LockedDoor(game));
    }
}
