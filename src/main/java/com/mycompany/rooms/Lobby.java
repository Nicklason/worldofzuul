package com.mycompany.rooms;

import com.mycompany.pointsofinterest.Girl;

public class Lobby extends Room {
    public Lobby () {
        super("lobby", "In the Lobby Start/End");
        setPointOfInterest(new Girl());
    }
    
}
