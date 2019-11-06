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
import pointsofinterest.Farmhouse;
import pointsofinterest.Irrigation;
import pointsofinterest.Pesticides;

public class Field extends Room {
    public Field (Game game) {
        super("field", "At the field");

        this.setPointOfInterest(new Irrigation(game));
        this.setPointOfInterest(new Farmhouse(game));
        this.setPointOfInterest(new Pesticides(game));
        
    }
}
