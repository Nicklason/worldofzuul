package com.mycompany.pointsofinterest;

import com.mycompany.pointsofinterest.PointsOfInterest;
import com.mycompany.worldofzuul.Inventory;

public abstract class PointOfInterest {
    private PointsOfInterest pointOfInterest;
    private String newDescription = null;
    public Inventory inventory = new Inventory();
    private Boolean fixed = false;

    /**
     * Non-fixable constructor
     * @param name
     * @param description
     */
    public PointOfInterest(PointsOfInterest pointOfInterest) {
        this.pointOfInterest = pointOfInterest;
    }

    /**
     * Get name
     * @return 
     */
    public String getName() {
        return pointOfInterest.getName();
    }

    /**
     * Returns true if the point of interest is fixed
     * @return
     */
    public Boolean isFixed () {
        return this.fixed;
    }

    /**
     * Mutator for fixed
     */
    public void setFixed () {
        if (this.pointOfInterest.isFixable()) {
            this.fixed = true;
        }
    }

    /**
     * Accessor for isFixable
     * @return
     */
    public Boolean isFixable () {
        return this.pointOfInterest.isFixable();
    }
    
    /**
     * 
     * @param newDescription 
     */
    public void setDescription(String newDescription){
        this.newDescription = newDescription;
    }

    /**
     * Get description
     * @return 
     */
    public String getDescription() {
        return this.newDescription != null ? this.newDescription : this.pointOfInterest.getDescription();
    }

    public String getLongDescription () {
        return (this.isFixed() ? this.pointOfInterest.getSuccessDescription() : this.getDescription()) + "\n" + getInventoryString();
    }

    public String getInventoryString () {
        return "Items: " + this.inventory.getItemsString();
    }
    
    public Boolean hasFunfact(){
        return this.pointOfInterest.hasFunfact();
    }
    
    public String getFunfact(){
        return this.pointOfInterest.funFact();
    }
}
