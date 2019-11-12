package items;

import worldofzuul.Game;
import pointsofinterest.PointOfInterest;
import items.Metalpatch;

public class Pumphandle extends Item {
    public Pumphandle (Game game) {
        super("pumphandle", "A pumphandle", game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();
        PointOfInterest pointOfInterestBoy =  game.getCurrentRoom().getPointOfInterest("boy");
        if (!game.getCurrentRoom().getName().equals("suburbs") || !pointOfInterest.getName().equals("waterpump")) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }

        pointOfInterest.setFixed();
        pointOfInterestBoy.setFixed();

        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        System.out.println(pointOfInterestBoy.getLongDescription());
        
        //pointOfInterestBoy.inventory.add(new Metalpatch(game);
        this.game.inventory.remove(this);
    }
    }
