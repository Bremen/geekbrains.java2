package homework1.competitors;

import homework1.interfaces.CanJump;
import homework1.interfaces.CanRun;

public abstract class Competitor implements CanJump, CanRun {
    protected String name;
    protected int jumpAbility;
    protected int runAbility;

    public Competitor(String name, int jumpAbility, int runAbility) {
        this.name = name;
        this.jumpAbility = jumpAbility;
        this.runAbility = runAbility;
    }

    protected boolean isJumped(final int height) {
        return jumpAbility >= height;
    }

    protected boolean isRunned(final int length) {
        return runAbility >= length;
    }
}
