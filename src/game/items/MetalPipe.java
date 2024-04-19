package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Status;
import game.actions.AttackAction;

/**
 * A class that represents a Metal Pipe which is a weapon item.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public class MetalPipe extends WeaponItem {

    private static final int METAL_PIPE_DAMAGE = 1;
    private static final int METAL_PIPE_HIT_RATE = 20;
    private static final String METAL_PIPE_VERB = "strikes";

    /**
     * Constructor of MetalPipe
     */
    public MetalPipe() {
        super("Metal Pipe", '!', METAL_PIPE_DAMAGE, METAL_PIPE_VERB, METAL_PIPE_HIT_RATE);
    }

    /**
     * Returns a list of actions that the otherActor can do to the location
     * @param otherActor the actor that is performing the action
     * @param location the location where the action is being performed
     * @return a list of actions that the otherActor can do to the location
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location){
        ActionList actions = new ActionList();
        if(!otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            String direction = "(" + location.x() + "," + location.y() + ")";
            actions.add(new AttackAction(otherActor, direction ,this));
        }

        return actions;
    }


}
