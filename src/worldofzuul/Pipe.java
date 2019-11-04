package worldofzuul;

public class Pipe extends Item {
    public Pipe (Game game) {
        super("pipe", "A pipe", game);
    }

    @Override
    public Boolean use() {
        if (getGame().getCurrentRoom().getName() != "Field" || getGame().getCurrentPointOfInterest().getName() != "Irrigation") {
            return false;
        }

        // TODO: Add logic for using the item

        return true;
    }    
}
