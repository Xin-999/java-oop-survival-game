package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Consumable;
import game.items.Fruit;

public class ConsumeAction extends Action {
    private Item item;

    public ConsumeAction(Item item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (item instanceof Consumable) {
            Consumable consumable = (Consumable) item;
            String effectDescription = consumable.consume(actor);
            actor.removeItemFromInventory(item);
            return actor + " consumes" + item + " and" + item + effectDescription;
        }
        return actor + " finds nothing to consume.";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item;
    }
}
