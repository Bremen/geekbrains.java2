package homework1.competitors;

public class Robot extends Competitor {
    public Robot(String name, int jumpAbility, int runAbility) {
        super(name, jumpAbility, runAbility);
    }

    @Override
    public boolean jump(int neededJumpHeight) {
        addTitleToPassageLogIfWasNot();
        addReportToLog(jumpingReport(neededJumpHeight) + "\n");

        return isAbleToJump(neededJumpHeight);
    }

    @Override
    public boolean run(int neededRunLength) {
        addTitleToPassageLogIfWasNot();
        addReportToLog(runningReport(neededRunLength) + "\n");

        return isAbleToRun(neededRunLength);
    }

    private void addTitleToPassageLogIfWasNot() {
        if (getPassageLog().isEmpty()) {
            addReportToLog("Robot - " + name + " results:\n");
        }
    }
}
