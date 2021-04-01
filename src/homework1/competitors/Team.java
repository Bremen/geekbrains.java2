package homework1.competitors;

public class Team {
    private String name;
    private Competitor[] competitors;

    public Team(String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public int getCompetitorsCount() {
        return competitors.length;
    }

    public Competitor getCompetitorAt(int i) {
        return competitors[i];
    }

    public void printCompetitorsResultsAll() {
        System.out.println("Результаты всех членов команды " + name + ":");
        for (Competitor competitor : competitors) {
            System.out.println(competitor.getPassageLog());
        }
    }

    public void printCompetitorsResultsFinished() {
        System.out.println("Результаты финишировавших членов команды " + name + ":");
        for (Competitor competitor : competitors) {
            if (competitor.isFinished()) {
                System.out.println(competitor.getPassageLog());
            }
        }
    }

    public static Team getDemoTeam() {
        Team demoTeam = new Team("DemoTeam",
                new Cat("Барсик", 20, 10),
                new Robot("R2D2", 10, 30),
                new Human("Karl", 20, 20),
                new Human("SuperKarl", 30, 30)
        );

        return demoTeam;
    }
}
