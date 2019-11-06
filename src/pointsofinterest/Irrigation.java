/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointsofinterest;

/**
 *
 * @author Nica
 */
import worldofzuul.Game;
import items.Pumphandle;

public class Irrigation extends PointOfInterest {
    public Irrigation (Game game) {
        super("irrigation", "The irrigation system is missing a pipe, water is running out on the ground", "You hav fixed the irrigation system, water is not getting wasted anymore.");
    
        this.inventory.add(new Pumphandle(game));
    }
}
