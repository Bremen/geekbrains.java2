package homework1.competitors;

import homework1.interfaces.CanJump;
import homework1.interfaces.CanRun;

public abstract class Competitor implements CanJump, CanRun {
    private String name;
    private int jumpAbility;
    private int runAbility;

    public Competitor(String name, int jumpAbility, int runAbility) {
        this.name = name;
        this.jumpAbility = jumpAbility;
        this.runAbility = runAbility;
    }
}
