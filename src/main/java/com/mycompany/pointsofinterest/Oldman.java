package com.mycompany.pointsofinterest;

import com.mycompany.worldofzuul.Game;
import com.mycompany.pointsofinterest.PointsOfInterest;

public class Oldman extends PointOfInterest {
    private boolean keycard = true;
    public Oldman (Game game) {
        super(PointsOfInterest.OLDMAN);
    }
    
    public void setKeycardFalse(){
        this.keycard = false;
    }
    
    public boolean getKeycard(){
        return keycard;
    }
}