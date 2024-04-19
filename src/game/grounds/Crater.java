package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import java.util.Random;

/**
 * An abstract class that represents a Crater.
 * Crater is a type of Ground that can spawn a creature.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public abstract class Crater extends Ground {
    private Random random = new Random();
    private int spawnRate;

    /**
     * Constructor of Crater that spawn a creature.
     *
     * @param displayChar character to display the Crater
     * @param spawnRate the rate of spawning a creature
     */
    public Crater(char displayChar, int spawnRate) {
        super(displayChar);
        this.spawnRate = spawnRate;
    }

    /**
     * Tick method for Crater.
     * If the random number is less than spawnRate and the location does not contain an actor, spawn a creature.
     *
     * @param location the location of the Crater
     */
    @Override
    public void tick(Location location) {
        if (random.nextInt(100) < spawnRate && !location.containsAnActor()) {
            location.addActor(spawnCreature());
        }
    }

    /**
     * Abstract method to spawn a creature.
     *
     * @return the creature to be spawned
     */
    protected abstract Actor spawnCreature();

}
