package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.AttackAction;
import java.util.ArrayList;
import java.util.Random;

public class AttackBehaviour implements Behaviour {
    private final Random random = new Random();
    private final int attackChance; // Chance to attack if multiple conditions are considered

    public AttackBehaviour(int attackChance) {
        this.attackChance = attackChance;
    }

    public AttackBehaviour() {
        this.attackChance = 100; // Defaults to always attack if the player is nearby
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        ArrayList<Action> actions = new ArrayList<>();
        // Iterate over all exits from the actor's current location
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            // Check if there is an actor in the adjacent location
            if (destination.containsAnActor()) {
                Actor otherActor = destination.getActor();
                if (isValidTarget(otherActor)){
                    actions.add(new AttackAction(otherActor, exit.getName()));
                }
            }
        }

        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        } else {
            return null;
        }

        // Return null if no player is nearby or attack condition is not met
    }
    private boolean isValidTarget(Actor actor) {
        // Implement logic to determine if the actor is a valid target
        // This could be checking for a specific capability, type, or any unique identifier
        // Example: return actor instanceof Player;
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
//        return !actor.getClass().equals(HuntsmanSpider.class); // Assuming you want to exclude other Huntsman Spiders
    }
}