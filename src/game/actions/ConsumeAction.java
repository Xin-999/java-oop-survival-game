package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;

/**
 * Action for consuming an item.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public class ConsumeAction extends Action {
    private Item item;

    /**
     * Constructor of ConsumeAction for an action of consuming an item.
     * @param item the item to be consumed
     */
    public ConsumeAction(Item item) {
        this.item = item;
    }

    /**
     * Execute the action of consuming an item.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a description of the action after it is executed
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (item instanceof Consumable) {
            Consumable consumable = (Consumable) item;
            String effectDescription = consumable.consume(actor);
            actor.removeItemFromInventory(item);
            return actor + " consumes " + item + " and " + item + effectDescription;
        }
        return actor + " finds nothing to consume.";
    }

    /**
     * Returns a string describing the action of consuming an item.
     * @param actor The actor performing the action.
     * @return a string describing the action of consuming an item
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item;
    }
}
