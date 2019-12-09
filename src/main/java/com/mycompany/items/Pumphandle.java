package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;

public class Pumphandle extends Item {

    public Pumphandle(Game game) {
        super(Items.PUMPHANDLE, game);
    }

    @Override
    public boolean usable () {
        return game.getCurrentRoom().getName().equals(Rooms.SUBURBS.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.WATERPUMP.getName());
    }

    @Override
    public boolean use() {
        if (!this.usable()) {
            return false;
        }

        game.getCurrentPointOfInterest().setFixed();
        game.getCurrentRoom().getPointOfInterest(PointsOfInterest.BOY.getName()).setDescription("“Thank you for fixing the pump, I will never play with water again!“");

        this.game.inventory.remove(this);

        return true;
    }
}
