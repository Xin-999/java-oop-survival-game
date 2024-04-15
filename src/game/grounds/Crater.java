package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import java.util.Random;


public abstract class Crater extends Ground {

    private Random random = new Random();
    private int spawnRate;


    public Crater(char displayChar, int spawnRate ) {
        super(displayChar);
        this.spawnRate = spawnRate;
    }

    @Override
    public void tick(Location location) {
        if (random.nextInt(100) < spawnRate && !location.containsAnActor()) {
            location.addActor(spawnCreature());
        }
    }

    protected abstract Actor spawnCreature();

}
