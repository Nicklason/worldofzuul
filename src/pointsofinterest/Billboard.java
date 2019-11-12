package pointsofinterest;
import items.EmptyBottle;
import worldofzuul.Game;

public class Billboard extends PointOfInterest {
    public Billboard (Game game) {
        super("billboard", "A billboard, can be used to show a photo", "Your photo is now being viewed by many people, hopefully they change their minds now");
        this.inventory.add(new EmptyBottle(game));
    }
    
    
}
