package homework1.obstacles;

import homework1.competitors.Competitor;
import homework1.competitors.Team;
import homework1.interfaces.Obstacle;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void overcomeBy(Team team) {
        for (Competitor competitor : team.getCompetitors()) {
            for (Obstacle obstacle : obstacles) {
                if (competitor.isOnDistance()) {
                    obstacle.overcomeBy(competitor);
                } else {
                    break;
                }
            }

            if (competitor.isOnDistance()) {
                competitor.addReportToLog("Успешно финишировал.\n");
            }
        }
    }
}
