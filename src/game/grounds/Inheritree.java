package game.grounds;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;
import edu.monash.fit2099.engine.positions.Exit;
import game.items.Fruit;
import game.items.FruitProducer;

public class Inheritree extends Ground implements FruitProducer {
    private int age = 0;
    private boolean isMature = false;
    private Random random = new Random();

    public Inheritree() {
        super('t'); // Initial display for sapling
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;

        if (age == 5) {
            setDisplayChar('T'); // Mature tree
            isMature = true;
        }

        produceFruit(location);
    }

    private boolean isMature() {
        return isMature;
    }

    @Override
    public void produceFruit(Location location) {
        // Use the encapsulated logic to check for maturity
        if (!isMature() && random.nextInt(100) < 30) {
            dropFruitAdjacent(location, false); // small fruit
        } else if (isMature() && random.nextInt(100) < 20) {
            dropFruitAdjacent(location, true);
        }
    }

    private void dropFruitAdjacent(Location location, boolean isLarge) {
        List<Exit> exits = location.getExits();
        if (exits.isEmpty()) {
            return; // If there are no exits, there's nowhere to drop the fruit
        }

        // Select a random exit
        Exit exit = exits.get(random.nextInt(exits.size()));
        Location destination = exit.getDestination();

        // Check if the destination can hold an item (it's not blocked by another item or character)
//        if (destination.canActorEnter(Actor)) {
        destination.addItem(new Fruit(isLarge, isLarge ? "Large" : "Small"));
//        }
    }
}
