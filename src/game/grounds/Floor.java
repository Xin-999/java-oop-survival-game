package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Ability;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Floor extends Ground {
    public Floor() {
        super('_');
    }

    /**
     * Check if actor can enter the spaceship
     * @param actor The actor that wants to enter the spaceship
     * @return true if actor can enter the spaceship, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        // Check if actor has the capability to enter
        return actor.hasCapability(Ability.ENTER_SPACESHIP);
    }
}
