package homework1.obstacles;

import homework1.competitors.Competitor;
import homework1.interfaces.Obstacle;

public class Track implements Obstacle {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public void overcomeBy(Competitor competitor) {
        competitor.run(length);
    }
}
