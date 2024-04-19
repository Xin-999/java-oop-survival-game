package game.items;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actions.ConsumeAction;


/**
 * Class representing a generic fruit in the game.
 * Can be extended or instantiated with different sizes/types.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public class Fruit extends Item implements Consumable{
    private final boolean isLarge;


    /**
     * Constructor for creating a fruit.
     *
     * @param isLarge Determines if the fruit is large (true) or small (false).
     */
    public Fruit(boolean isLarge, String size) {
        super((isLarge ? "Large Fruit" : "Small Fruit"), isLarge ? 'O' : 'o', true);
        this.isLarge = isLarge;

    }

    /**
     * Checks if the fruit is large.
     *
     * @return True if the fruit is large, false otherwise.
     */
    public boolean isLarge() {
        return isLarge;
    }

    /**
     * This method generates the actions that can be performed with this fruit.
     * @param owner The actor who has the fruit in their inventory or who is interacting with it.
     * @return An ActionList containing all actions applicable to this fruit.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = new ActionList();
        // Add a consume action to the fruit that allows the owner to consume the fruit.
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Executes the effect of consuming the fruit.
     * @param actor the Actor consuming the fruit.
     * @return a description of the consumption effect.
     */
    @Override
    public String consume(Actor actor) {
        int healingAmount = isLarge ? 2 : 1;
        actor.heal(healingAmount);
        return " heals " + actor + " by " + healingAmount + " points";
    }



}


