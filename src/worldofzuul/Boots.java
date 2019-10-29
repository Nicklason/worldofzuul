/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldofzuul;

/**
 *
 * @author niklas
 */
public class Boots extends Item{

    public Boots(String name, String description, Game game) {
        super(name, description, game);
    }

    
    
   @Override
    public Boolean use() {
        if ("Boat".equals(getGame().getCurrentPointOfInterest().getName()) && 
                "Lake".equals(getGame().getCurrentRoom().getName())) 
        {
        return true;
        }
        
        return false;
                
                
    }
    
    
    
    
}
