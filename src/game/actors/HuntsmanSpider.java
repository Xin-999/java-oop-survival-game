package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.Status;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.items.MetalPipe;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that represents a Huntsman Spider.
 * @author Ang Qiao Xin
 * @version 1.0
 */
public class HuntsmanSpider extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    /**
     * Constructor for HuntsmanSpider
     * Added WanderBehaviour and AttackBehaviour to spider.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        this.behaviours.put(999, new WanderBehaviour());
        // In the Huntsman Spider's constructor or initialization method
        this.behaviours.put(1, new AttackBehaviour());
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }

    /**
     * The huntsman spider can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return actions that can be performed by otherActor
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new AttackAction(this, direction));
        }

        return actions;
    }

    /**
     * Huntsman Spider has default weapon with 25% chance to hit player
     * @return IntrinsicWeapon that can attack player
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        // 25 represents a 25% chance to hit
        return new IntrinsicWeapon(1, "strikes with a long leg", 25);
    }



}
