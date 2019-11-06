package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;
import items.ShoppingCart;
import items.Cola;

public class Coin extends Item {
    public Coin (Game game) {
        super("coin", "A coin", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        if (!game.getCurrentRoom().getName().equals("bigcity") || !pointOfInterest.getName().equals("store") || !pointOfInterest.getName().equals("vendingmachine")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());

        this.game.inventory.remove(this);

        if (pointOfInterest.getName().equals("store")) {
            // We used the coin to unluck a shopping cart
            this.game.inventory.add(new ShoppingCart(game));
        } else {
            // The coin was used in a vending machine to get a cola, add the cola to the inventory of the vending machine
            pointOfInterest.inventory.add(new Cola(game));
        }
    }
}
