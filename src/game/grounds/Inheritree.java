package game.grounds;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;
import edu.monash.fit2099.engine.positions.Exit;
import game.items.Fruit;

/**
 * A class that represents an Inheritree.
 * Inheritree is a type of Ground that can produce fruits.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public class Inheritree extends Ground {
    private int age;
    private boolean isMature = false;
    private Random random = new Random();

    /**
     * Constructor for Inheritree to produce fruits.
     */
    public Inheritree() {
        super('t'); // Initial display for sapling
        age = 0;
    }

    /**
     * Tick method for Inheritree.
     * If the age is greater than 5, set the display character to 'T' and the tree is mature.
     * Produce fruit if the tree is mature.
     *
     * @param location the location of the Inheritree
     */
    @Override
    public void tick(Location location) {
        age++;

        if (age > 5) {
            setDisplayChar('T'); // Mature tree
            isMature = true;
        }

        produceFruit(location);
    }

    /**
     * Check if the tree is mature.
     *
     * @return true if the tree is mature, false otherwise
     */
    private boolean isMature() {
        return isMature;
    }

    /**
     * Produce small fruit and large fruit when the tree is mature.
     *
     * @param location the location of the Inheritree
     */
    public void produceFruit(Location location) {
        // Use the encapsulated logic to check for maturity
        if (!isMature() && random.nextInt(100) < 30) {
            dropFruitAdjacent(location, false); // small fruit
        } else if (isMature() && random.nextInt(100) < 20) {
            dropFruitAdjacent(location, true);
        }
    }

    /**
     * Drop fruit around the tree.
     *
     * @param location the location of the Inheritree
     * @param isLarge true if the fruit is large, false otherwise
     */
    private void dropFruitAdjacent(Location location, boolean isLarge) {
        List<Exit> exits = location.getExits();
        if (exits.isEmpty()) {
            return; // If there are no exits, there's nowhere to drop the fruit
        }

        // Select a random exit
        Exit exit = exits.get(random.nextInt(exits.size()));
        Location destination = exit.getDestination();
        destination.addItem(new Fruit(isLarge,  isLarge ? "Large" : "Small"));

    }
}
