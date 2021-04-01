package homework1.competitors;

public class Robot extends Competitor {
    public Robot(String name, int jumpAbility, int runAbility) {
        super(name, jumpAbility, runAbility);
    }


    @Override
    public boolean jump(int neededJumpHeight) {
        return false;
    }

    @Override
    public boolean run(int neededRunLength) {
        return false;
    }
}
