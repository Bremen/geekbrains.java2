package homework1.competitors;

import homework1.interfaces.CanJump;
import homework1.interfaces.CanRun;

public abstract class Competitor implements CanJump, CanRun {
    private int jumpLimit;
    private int runLimit;

    private StringBuilder passageLog = new StringBuilder();
    private boolean onDistance;

    Competitor(String name, int jumpAbility, int runAbility) {
        this.jumpLimit = jumpAbility;
        this.runLimit = runAbility;
        this.onDistance = true;

        addReportToLog(getClass().getSimpleName() + " - " + name + " results:\n");
    }

    private boolean isAbleToJump(int neededJumpHeight) {
        return jumpLimit >= neededJumpHeight;
    }

    private boolean isAbleToRun(int length) {
        return runLimit >= length;
    }

    public void addReportToLog(String report) {
        passageLog.append(report);
    }

    String getPassageLog() {
        return passageLog.toString();
    }

    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public String toString() {
        return passageLog.toString();
    }

    @Override
    public void jump(int neededJumpHeight) {
        onDistance = isAbleToJump(neededJumpHeight);

        StringBuilder report = new StringBuilder("перепрыгнул препятствие высотой " + neededJumpHeight + "\n");
        reportEvent(report);
    }

    @Override
    public void run(int neededRunLength) {
        onDistance = isAbleToRun(neededRunLength);

        StringBuilder report = new StringBuilder("пробежал препятствие длинной " + neededRunLength + "\n");
        reportEvent(report);
    }

    private void reportEvent(StringBuilder report) {
        if (!onDistance) {
            report.insert(0, "не ");
            report.append("Cошёл с дистанции.\n");
        }

        addReportToLog(report.toString());
    }
}
