package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.HuntsmanSpider;

public class SpiderCrater extends Crater{
    public SpiderCrater() {
        super('u', 5); // Specify that spiders have a 5% chance to spawn
    }

    @Override
    protected Actor spawnCreature() {
        return new HuntsmanSpider();
    }


}
