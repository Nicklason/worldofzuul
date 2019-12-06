package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.rooms.Factory;
import com.mycompany.rooms.Room;

public class Keycard extends Item {
    public Keycard (Game game) {
        super(Items.KEYCARD, game);
    }

    @Override
    public boolean usable () {
        return game.getCurrentRoom().getName().equals(Rooms.STREET.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.LOCKEDDOOR.getName());
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }

        game.getCurrentPointOfInterest().setFixed();

        this.game.inventory.remove(this);

        Factory factory = new Factory(game);
        Room street = game.getCurrentRoom();

        street.setExit(factory);
        factory.setExit(street);

        return true;
    }
}