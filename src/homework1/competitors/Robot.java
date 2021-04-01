package homework1.competitors;

public class Robot extends Competitor {
    public Robot(String name, int jumpAbility, int runAbility) {
        super(name, jumpAbility, runAbility);
    }

    @Override
    public boolean jump(int neededJumpHeight) {
        System.out.printf("Robot: " + jumpingReport(neededJumpHeight) + "\n");
        return isAbleToJump(neededJumpHeight);
    }

    @Override
    public boolean run(int neededRunLength) {
        System.out.printf("Robot: " + runningReport(neededRunLength) + "\n");
        return isAbleToRun(neededRunLength);
    }
}
