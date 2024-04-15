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

    @Override
    public boolean canActorEnter(Actor actor) {
        // Check if actor has the capability to enter
        return actor.hasCapability(Ability.ENTER_SPACESHIP);
    }
}
