package game.items;

import edu.monash.fit2099.engine.actors.Actor;

public interface Consumable {
    /**
     * Executes the effect of consuming the item.
     * @param actor the Actor consuming the item.
     * @return a description of the consumption effect.
     */
    String consume(Actor actor);
}
