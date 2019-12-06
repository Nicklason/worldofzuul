package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;

public class ShoppingCart extends Item {
    public ShoppingCart (Game game) {
        super(Items.SHOPPINGCART, game);
    }

    @Override
    public boolean usable () {
        return game.getCurrentRoom().getName().equals(Rooms.FIELD.getName()) && game.getCurrentPointOfInterest().getName().equals(PointsOfInterest.PESTICIDES.getName());
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }

        game.getCurrentPointOfInterest().setFixed();

        this.game.inventory.remove(this);

        return true;
    }
}
