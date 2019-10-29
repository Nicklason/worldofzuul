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
public class Pipe extends Item{


    public Pipe(String name, String description, Game game) {
        super(name, description, game);
    }




    @Override
    public Boolean use() {
        if ("Irrigation".equals(getGame().getCurrentPointOfInterest().getName()) && 
                "Field".equals(getGame().getCurrentRoom().getName())) 
        {
        return true;
        }
        
        return false;
                
                
    }
    
    
    
    
    
}
