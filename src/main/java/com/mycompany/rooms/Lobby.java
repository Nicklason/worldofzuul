package com.mycompany.rooms;

import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.Girl;

public class Lobby extends Room {
    public Lobby () {
        super(Rooms.LOBBY);
        setPointOfInterest(new Girl());
    }
    
}
