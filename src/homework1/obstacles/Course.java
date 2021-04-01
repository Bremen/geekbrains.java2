package homework1.obstacles;

import homework1.competitors.Team;
import homework1.interfaces.Obstacle;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        nextCompetitor:
        for (int i = 0; i < team.getCompetitorsCount(); i++) {
            for (int j = 0; j < obstacles.length; j++) {
                boolean notOvercame = !obstacles[j].doIt(team.getCompetitorAt(i));

                if (notOvercame) {
                    team.getCompetitorAt(i).addReportToLog("Cошёл с дистанции.\n");
                    continue nextCompetitor;
                }
            }

            team.getCompetitorAt(i).setFinished(true);
            team.getCompetitorAt(i).addReportToLog("Успешно финишировал.\n");
        }
    }

    public static Course getDefaultCourse() {
        Course defaultCourse = new Course(
                new Wall(10),
                new Track(10),
                new Wall(20),
                new Track(20),
                new Wall(30),
                new Track(30)
        );

        return defaultCourse;
    }
}
