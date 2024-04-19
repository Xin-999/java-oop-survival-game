package game.items;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface that represents an item that can be consumed.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public interface Consumable {
    /**
     * Executes the effect of consuming the item.
     * @param actor the Actor consuming the item.
     * @return a description of the consumption effect.
     */
    String consume(Actor actor);
}
