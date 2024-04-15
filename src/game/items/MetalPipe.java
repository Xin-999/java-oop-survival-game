package game.items;

import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class MetalPipe extends WeaponItem implements Weapon {

    private static final int METAL_PIPE_DAMAGE = 1;
    private static final int METAL_PIPE_HIT_RATE = 20;
    private static final String METAL_PIPE_VERB = "strikes";

    public MetalPipe() {
        super("Metal Pipe", '!', METAL_PIPE_DAMAGE, METAL_PIPE_VERB, METAL_PIPE_HIT_RATE);
    }
}
