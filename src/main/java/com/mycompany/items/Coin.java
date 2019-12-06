package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.items.ShoppingCart;
import com.mycompany.items.Cola;

public class Coin extends Item {
    public Coin (Game game) {
        super(Items.COIN, game);
    }

    @Override
    public boolean usable () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        return game.getCurrentRoom().getName().equals(Rooms.BIGCITY.getName()) && (pointOfInterest.getName().equals(PointsOfInterest.STORE.getName()) || pointOfInterest.getName().equals(PointsOfInterest.VENDINGMACHINE.getName()));
    }

    @Override
    public boolean use () {
        if (!this.usable()) {
            return false;
        }

        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();
        
        this.game.inventory.remove(this);

        if (pointOfInterest.getName().equals(PointsOfInterest.STORE.getName())) {
            // We used the coin to unluck a shopping cart
            this.game.inventory.add(new ShoppingCart(game));
        } else {
            // The coin was used in a vending machine to get a cola, add the cola to the inventory of the vending machine
            pointOfInterest.inventory.add(new Cola(game));
        }

        return true;
    }
}
