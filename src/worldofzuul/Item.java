package worldofzuul;

public class Item {
    private String name;
    private String description;
    private PointOfInterest pointOfInterest;
    private boolean isSwitchable;
    private Item switcher;

    /**
     * constructs an item object using 2 strings as parameters
     * @param name
     * @param description
     * @param pointOfInterest Location that the item can be used at
     */
    public Item (String name, String description, PointOfInterest pointOfInterest) {
        this.name = name;
        this.description = description;
        this.pointOfInterest = pointOfInterest;
        isSwitchable = false;
    }
      public Item (String name, String description, PointOfInterest pointOfInterest,Item switcher) {
        this.name = name;
        this.description = description;
        this.pointOfInterest = pointOfInterest;
        isSwitchable = true;
        this.switcher=switcher;
    }

    /**
     * Retunere name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Retunere Description
     * @return description 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if item can be used at a point of interest
     * @param pointOfInterest
     * @return
     */
    public Boolean usableAtPointOfInterest (PointOfInterest pointOfInterest) {
        return this.pointOfInterest == pointOfInterest;
    }
    public boolean getIsSwitchable(){
        return this.isSwitchable;
    }
    public Item getSwitcher(){
        return this.switcher;
    }
}
