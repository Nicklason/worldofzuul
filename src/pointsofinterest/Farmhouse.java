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
import items.Boots;
import items.Metalpatch;
import worldofzuul.Game;

public class Farmhouse extends PointOfInterest {
    public Farmhouse (Game game) {
        super("farmhouse", "An abandoned farmhouse, maybe something usefull");
    
        this.inventory.add(new Metalpatch(game));
        this.inventory.add(new Boots(game));
    }
}