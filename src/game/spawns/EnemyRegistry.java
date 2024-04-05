package game.spawns;

import edu.monash.fit2099.engine.actors.Actor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class EnemyRegistry {
    private List<Supplier<Actor>> enemies = new ArrayList<>();
    private Random random = new Random();

    public void registerEnemy(Supplier<Actor> enemySupplier) {
        enemies.add(enemySupplier);
    }

    public Actor getRandomEnemy() {
        if (enemies.isEmpty()) {
            return null;
        }
        return enemies.get(random.nextInt(enemies.size())).get();
    }
}
