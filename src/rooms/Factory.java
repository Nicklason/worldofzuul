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
import pointsofinterest.Map;

public class Factory extends Room {
    public Factory (Game game) {
        super("factory", "At the factory");

        this.setPointOfInterest(new Map(game));
        
        
    }
}