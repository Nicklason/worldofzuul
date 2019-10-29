package worldofzuul;

public class PointOfInterest {
    private String name;
    private String description;
    public Inventory inventory;
    
    /**
     * PointOfInterest Constructor
     * @param name
     * @param description 
     */
    public PointOfInterest(String name, String description){
        this.name = name;
        this.description = description;
        this.inventory = new Inventory();
    }
    
    /**
     * Get name
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get description
     * @return 
     */
    public String getDescription() {
        return description;
    }
}
