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

    protected boolean isAbleToJump(final int neededJumpHeight) {
        return jumpAbility >= neededJumpHeight;
    }

    protected boolean isAbleToRun(final int length) {
        return runAbility >= length;
    }

    protected String jumpingReport(final int neededJumpHeight) {
        String actionReport = "";

        if (!isAbleToJump(neededJumpHeight)) {
            actionReport = "не ";
        }

        return name + " " + actionReport + "перепрыгнул препятствие высотой " + neededJumpHeight;
    }

    protected String runningReport(final int neededRunLength) {
        String actionReport = "";

        if (!isAbleToRun(neededRunLength)) {
            actionReport = "не ";
        }

        return name + " " + actionReport + "пробежал препятствие длинной " + neededRunLength;
    }

    public String getName() {
        return name;
    }
}
