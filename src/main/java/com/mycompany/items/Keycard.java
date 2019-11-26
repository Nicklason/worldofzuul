package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.rooms.Factory;
import com.mycompany.rooms.Room;

public class Keycard extends Item {
    public Keycard (Game game) {
        super(Items.KEYCARD, game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals(Rooms.STREET.getName()) || !pointOfInterest.getName().equals(PointsOfInterest.LOCKEDDOOR.getName())) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        this.game.inventory.remove(this);

        Factory factory = new Factory(game);
        Room street = game.getCurrentRoom();

        street.setExit(factory);
        factory.setExit(street);

        System.out.println("New exit factory added");
    }
}