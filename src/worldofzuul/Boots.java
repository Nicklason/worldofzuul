package worldofzuul;

public class Boots extends Item {
    public Boots(Game game) {
        super("Boots", "A pair of boots used to traverse wet terrain", game);
    }

    @Override
    public Boolean use() {
        if (getGame().getCurrentRoom().getName() == "Lake" && getGame().getCurrentPointOfInterest().getName() == "Boat") {
            return true;
        }

        // TODO: Add logic for using the item

        return false;      
    }
}
