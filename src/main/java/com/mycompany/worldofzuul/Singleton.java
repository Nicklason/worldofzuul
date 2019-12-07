/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.worldofzuul;

/**
 *
 * @author Nica
 */
public class Singleton {
    
    // static variable single_instance of type Singleton 
    private static Game single_instance = null; 
  
    
    // private constructor restricted to this class itself 
    private Singleton() 
    { 
       // single_instance = new Game();
    } 
  
    // static method to create instance of Singleton class 
    public static Game getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Game(); 
  
        return single_instance; 
    } 
}
