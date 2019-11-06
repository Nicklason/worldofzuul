/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rooms;

/**
 *
 * @author Nica
 */
import worldofzuul.Game;
import pointsofinterest.Store;
import pointsofinterest.Vendingmachine;
import pointsofinterest.Oldman;

public class Bigcity extends Room {
    public Bigcity (Game game) {
        super("bigcity", "in the bigcity");

        this.setPointOfInterest(new Vendingmachine());
        this.setPointOfInterest(new Store());
        this.setPointOfInterest(new Oldman(game));
        
    }
}