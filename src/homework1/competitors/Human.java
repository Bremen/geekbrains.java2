package homework1.competitors;

public class Human extends Competitor {
    public Human(String name, int jumpAbility, int runAbility) {
        super(name, jumpAbility, runAbility);
    }

    @Override
    public boolean jump(int neededJumpHeight) {
        System.out.printf("Human: " + jumpingReport(neededJumpHeight) + "\n");
        return isAbleToJump(neededJumpHeight);
    }

    @Override
    public boolean run(int neededRunLength) {
        System.out.printf("Human: " + runningReport(neededRunLength) + "\n");
        return isAbleToRun(neededRunLength);
    }
}
