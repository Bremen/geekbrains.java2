package homework1.obstacles;

import homework1.competitors.Competitor;
import homework1.interfaces.Obstacle;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doIt(Competitor competitor) {
        return competitor.jump(height);
    }
}
