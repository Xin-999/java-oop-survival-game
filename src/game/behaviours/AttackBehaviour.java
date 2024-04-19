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

/**
 * Behaviour for attacking an actor.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public class AttackBehaviour implements Behaviour {
    private final Random random = new Random();
    public AttackBehaviour() {
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
        return actor.hasCapability(Status.HOSTILE_TO_ENEMY);

    }
}