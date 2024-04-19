package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.HuntsmanSpider;

/**
 * A class that represents a SpiderCrater.
 * SpiderCrater is a type of Crater that can spawn a HuntsmanSpider.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public class SpiderCrater extends Crater{
    /**
     * Constructor of SpiderCrater that spawn a HuntsmanSpider.
     */
    public SpiderCrater() {
        super('u', 5); // Specify that spiders have a 5% chance to spawn
    }

    /**
     * Spawn a HuntsmanSpider.
     *
     * @return the HuntsmanSpider to be spawned
     */
    @Override
    protected Actor spawnCreature() {
        return new HuntsmanSpider();
    }


}
