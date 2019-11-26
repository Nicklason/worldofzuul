package com.mycompany.pointsofinterest;

import com.mycompany.worldofzuul.Game;

public class Oldman extends PointOfInterest {
    private boolean keycard = true;
    public Oldman (Game game) {
        super("oldman", "Oldman: Hey can you please get me some water im really thirsty", "you helped the old man get water in return he gave you a keycard");
    }
    
    public void setKeycardFalse(){
        this.keycard = false;
    }
    
    public boolean getKeycard(){
        return keycard;
    }
}