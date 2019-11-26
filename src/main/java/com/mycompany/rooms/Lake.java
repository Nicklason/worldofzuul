package com.mycompany.rooms;

import com.mycompany.rooms.Rooms;
import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.Boat;
import com.mycompany.pointsofinterest.LeakingPipe;
import com.mycompany.pointsofinterest.Bridge;

public class Lake extends Room {
    public Lake (Game game) {
        super(Rooms.LAKE);

        this.setPointOfInterest(new Boat());
        this.setPointOfInterest(new LeakingPipe());
        this.setPointOfInterest(new Bridge(game));
    }
}
