package worldofzuul;

public class PointOfInterest {
    private String name;
    private String description;
    private Boolean isFixable;
    private String successDescription;
    public Inventory inventory = new Inventory();
    private Boolean fixed = false;

    /**
     * Non-fixable constructor
     * @param name
     * @param description
     */
    public PointOfInterest(String name, String description) {
        this.name = name;
        this.description = description;
        this.isFixable = false;
    }

    /**
     * PointOfInterest Constructor
     * @param name
     * @param description
     * @param successDescription
     */
    public PointOfInterest(String name, String description, String successDescription) {
        this.name = name;
        this.description = description;
        this.successDescription = successDescription;
        this.isFixable = true;
    }

    /**
     * Get name
     * @return 
     */
    public String getName() {
        return name;
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
        if (this.isFixable()) {
            this.fixed = true;
        }
    }

    /**
     * Accessor for isFixable
     * @return
     */
    private Boolean isFixable () {
        return this.isFixable;
    }

    /**
     * Get description
     * @return 
     */
    public String getDescription() {
        return description;
    }

    public String getLongDescription () {
        return (this.isFixed() ? successDescription : description) + "\n" + getInventoryString();
    }

    public String getInventoryString () {
        return "Items: " + this.inventory.getItemsString();
    }
}
