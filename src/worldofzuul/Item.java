package worldofzuul;

public class Item {
    private String name;
    private String description;
/**
 * constructs an item object using 2 strings as parameters
 * @param name
 * @param description 
 */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
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
    
    
    
    
}
