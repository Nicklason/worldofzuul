package com.mycompany.items;

import com.mycompany.items.Items;
import com.mycompany.rooms.Rooms;
import com.mycompany.pointsofinterest.PointsOfInterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointOfInterest;
import com.mycompany.items.Photo;

public class Camera extends Item {
    public Camera (Game game) {
        super(Items.CAMERA, game);
    }

    @Override
    public void use () {
        PointOfInterest pointOfInterest = game.getCurrentPointOfInterest();

        // If the poi is already fixed, then don't allow the item to be used (it would keep adding " (with photo)" to the name)
        if (!game.getCurrentRoom().getName().equals(Rooms.FACTORY.getName()) || !pointOfInterest.getName().equals(PointsOfInterest.MAP.getName()) || pointOfInterest.isFixed()) {
            System.out.println("Can't use " + this.getName() + " here");
            return;
        }
        
        pointOfInterest.setFixed();
        
        System.out.println("Using " + this.getName() + " at " + pointOfInterest.getName());
        System.out.println(pointOfInterest.getLongDescription());
        System.out.println("A photo has been added to your inventory");

        this.game.inventory.remove(this);
        this.game.inventory.add(new Photo(game));
    }
}
