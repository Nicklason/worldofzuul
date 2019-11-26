package com.mycompany.items;

import com.mycompany.items.Items;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.items.ShoppingCart;
import com.mycompany.items.Cola;

public class Coin extends Item {
    public Coin (Game game) {
        super(Items.COIN, game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("bigcity") && (!pointOfInterest.getName().equals("store") || !pointOfInterest.getName().equals("vendingmachine"))) {
            System.out.println("Can't use " + this.getName() + " here");
            System.out.println(pointOfInterest.getName());
            System.out.println(!pointOfInterest.getName().equals("vendingmachine"));
            return;
        }

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        
        this.game.inventory.remove(this);

        if (pointOfInterest.getName().equals("store")) {
            // We used the coin to unluck a shopping cart
            this.game.inventory.add(new ShoppingCart(game));
            System.out.println(pointOfInterest.getLongDescription());
            System.out.println("A shopping cart has been added to your inventory");
        } else {
            // The coin was used in a vending machine to get a cola, add the cola to the inventory of the vending machine
            pointOfInterest.inventory.add(new Cola(game));
            System.out.println(pointOfInterest.getLongDescription());
        }
    }
}
