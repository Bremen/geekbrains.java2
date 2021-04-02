package homework1.competitors;

import java.util.Arrays;

public class Team {
    private String name;
    private Competitor[] competitors;

    public Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public void printCompetitorsResultsAll() {
        System.out.println("Результаты всех членов команды " + name + ":");
        for (Competitor competitor : competitors) {
            System.out.println(competitor.getPassageLog());
        }
    }

    public void printCompetitorsResultsFinished() {
        System.out.println("Результаты финишировавших членов команды " + name + ":");
        Arrays.stream(competitors).filter(Competitor::isOnDistance).forEach(System.out::println);
    }

    public final Competitor[] getCompetitors() {
        return competitors;
    }
}
