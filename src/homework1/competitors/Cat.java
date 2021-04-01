package homework1.competitors;

public class Cat extends Competitor{
    public Cat(String name, int jumpAbility, int runAbility) {
        super(name, jumpAbility, runAbility);
    }

    @Override
    public boolean jump(int neededJumpHeight) {
        System.out.printf("Cat: " + jumpingReport(neededJumpHeight) + "\n");
        return isAbleToJump(neededJumpHeight);
    }

    @Override
    public boolean run(int neededRunLength) {
        System.out.printf("Cat: " + runningReport(neededRunLength) + "\n");
        return isAbleToRun(neededRunLength);
    }
}
