package worldofzuul;

public abstract class Item {
    private String name;
    private String description;
    private Game game;

    /**
     * constructs an item object using 2 strings as parameters
     * @param name
     * @param description 
     */
    public Item (String name, String description, Game game) {
        this.name = name;
        this.description = description;
        this.game = game;
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
