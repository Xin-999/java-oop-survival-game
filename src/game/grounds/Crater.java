package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.HuntsmanSpider;
import game.spawns.EnemyRegistry;
import game.spawns.Spawner;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Crater extends Ground implements Spawner {
    private static EnemyRegistry enemyRegistry = new EnemyRegistry();
    private Random random = new Random();

    static {
        // Register known enemies here, HuntsmanSpider as an example
        enemyRegistry.registerEnemy(HuntsmanSpider::new);
        // Additional enemies can be registered similarly
    }

    public Crater() {
        super('u'); // Representing crater with 'u'
    }

    @Override
    public void tick(Location location) {
        if (random.nextInt(100) < 5) { // 5% chance to attempt to spawn an enemy
            spawn(location);
        }
    }

    @Override
    public void spawn(Location location) {
        List<Exit> exits = location.getExits();
        if (!exits.isEmpty()) {
            // Choose a random exit for spawning
            Exit exit = exits.get(random.nextInt(exits.size()));
            Location spawnLocation = exit.getDestination();

            // Check if the selected location is free

                Actor enemy = enemyRegistry.getRandomEnemy();
                if (enemy != null) {
                    spawnLocation.addActor(enemy);
                }

        }
    }
}
