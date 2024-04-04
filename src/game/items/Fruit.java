package game.items;
import edu.monash.fit2099.engine.items.Item;


/**
 * Class representing a generic fruit in the game.
 * Can be extended or instantiated with different sizes/types.
 */
public class Fruit extends Item {
    private final boolean isLarge;


    /**
     * Constructor for creating a fruit.
     *
     * @param isLarge Determines if the fruit is large (true) or small (false).
     */
    public Fruit(boolean isLarge, String size) {
        super((isLarge ? " Large Fruit" : " Small Fruit"), isLarge ? 'O' : 'o', true);
        this.isLarge = isLarge;

    }

    /**
     * Checks if the fruit is large.
     *
     * @return True if the fruit is large, false otherwise.
     */
    public boolean isLarge() {
        return isLarge;
    }

}


