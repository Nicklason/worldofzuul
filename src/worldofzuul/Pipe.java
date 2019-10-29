package worldofzuul;

public class Pipe extends Item {
    public Pipe (Game game) {
        super("Pipe", "A pipe", game);
    }

    @Override
    public Boolean use() {
        if (getGame().getCurrentRoom().getName() == "Field" && getGame().getCurrentPointOfInterest().getName() == "Irrigation") {
            return true;
        }

        // TODO: Add logic for using the item

        return false;
    }    
}
