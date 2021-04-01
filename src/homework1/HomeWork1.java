package homework1;

//        1. Разобраться с кодом (https://github.com/Alexandr1907/JavaCore2/tree/lesson1)

//        2. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь
//        бегать и прыгать (методы просто выводят информацию о действии в консоль). -- Пояснение: Каждый класс должен
//        наследовать оба интерфейса.

//        3. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
//        соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал,
//        не смог пробежать и т.д.).

//        4. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

//        5. У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
//        Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет. -- Пояснение:
//        Пример для стены. В методе интерфейса принимайте на вход высоту "boolean jump(int height);". При вызове метода,
//        передавайте соответственно высоту стены, которую пытаемся перепргынуть, а в самом методе уже реализуйте логику
//        проверки и возвращайте результат, справился или нет. У самого класса в констркуторе добавьте запрос и
//        инициализацию переменных, на какую высоту может прыгнуть создаваемый объект. В реализации метода интерфейса
//        сравниваем переданную высоту и высоту, которую может преодалеть объект

//        Задания для собственного развития
//        1. Добавить класс Team, который будет содержать: название команды, массив из 4-х участников (т.е. в конструкторе
//        можно сразу всех участников указывать), метод для вывода информации о членах команды прошедших дистанцию,
//        метод вывода информации обо всех членах команды.
//        2. Добавить класс Course (полоса препятствий), в котором будут находиться: массив препятствий, метод который
//        будет просить команду пройти всю полосу;
//        То есть в итоге должно быть:
//
//public static void main(String[] args) {
//        Course c = new Course(...); // Создаем полосу препятствий
//        Team team = new Team(...); // Создаем команду
//        c.doIt(team); // Просим команду пройти полосу
//        team.showResults(); // Показываем результаты
//        }

import homework1.competitors.Cat;
import homework1.competitors.Competitor;
import homework1.competitors.Human;
import homework1.competitors.Robot;
import homework1.interfaces.Obstacle;
import homework1.obstacles.Track;
import homework1.obstacles.Wall;

public class HomeWork1 {
    public static void demonstrate() {
        int obstaclesCount = 6;
        Obstacle[] obstacles = new Obstacle[obstaclesCount];

        obstacles[0] = new Wall(10);
        obstacles[1] = new Track(10);
        obstacles[2] = new Wall(20);
        obstacles[3] = new Track(20);
        obstacles[4] = new Wall(30);
        obstacles[5] = new Track(30);

        int competitorsCount = 3;
        Competitor[] competitors = new Competitor[competitorsCount];

        competitors[0] = new Cat("Барсик", 20, 10);
        competitors[1] = new Robot("R2D2", 10, 30);
        competitors[2] = new Human("Karl", 30, 30);

        nextCompetitor:
        for (int i = 0; i < competitors.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                boolean notOvercame = !obstacles[j].doIt(competitors[i]);

                if (notOvercame) {
                    System.out.println("Участник " + competitors[i].getName() + " сошёл с дистанции.\n");
                    continue nextCompetitor;
                }
            }

            System.out.println("Участник " + competitors[i].getName() + " успешно финишировал.\n");
        }
    }
}
