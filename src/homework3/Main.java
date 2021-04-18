package homework3;

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать сколько раз встречается каждое слово.

//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи.
// С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть
// несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.

//Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
// дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
// Консоль желательно не использовать (в том числе Scanner),
// тестировать просто из метода main() прописывая add() и get().

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1.
        String[] strArr = {"A", "A", "B", "A", "B", "C", "A", "B", "C", "D", "A", "B", "C", "D", "E"};
        System.out.println("Массив: " + Arrays.toString(strArr));
        printUniqueValuesAndTheirCounts(strArr);

        System.out.println();

        // 2.
        Phonebook phonebook = new Phonebook();
        phonebook.add("Ann", "12-46");
        phonebook.add("Micke", "59-35");
        phonebook.add("Kate", "46-25");
        phonebook.add("Kate", "91-32");
        phonebook.add("Kate", "86-24");
        phonebook.add("Judi", "94-37");
        phonebook.add("Judi", "64-53");

        System.out.println("Phonebook: " + phonebook);

        String name = "Kate";
        System.out.println(name + "'s phonenumbers: " + phonebook.get(name));
    }

    private static void printUniqueValuesAndTheirCounts(String[] strArr) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : strArr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        System.out.println("Список уникальных слов в массиве:");
        System.out.println(map.keySet());

        System.out.println("Список уникальных слов и их повторений в массиве:");
        System.out.println(map);
    }
}
