package homework1.competitors;

public class Cat extends Competitor{
    public Cat(String name, int jumpAbility, int runAbility) {
        super(name, jumpAbility, runAbility);
    }

    @Override
    public boolean jump(int neededJumpHeight) {
        String actionReport = "не перепрыгнул";

        if (isJumped(neededJumpHeight)) {
            actionReport = "перепрыгнул";
        }

        System.out.printf("Cat: " + name + "%s препятствие длиной " + jumpAbility, actionReport);

        return isJumped(neededJumpHeight);
    }

    @Override
    public boolean run(int neededRunLength) {
        boolean didIt = false;
        String actionReport = "не пробежал";

        if (runAbility >= neededRunLength) {
            didIt = true;
            actionReport = "пробежал";
        }

        System.out.printf("Cat: " + name + "%s препятствие длиной " + runAbility, actionReport);

        return didIt;
    }
}
