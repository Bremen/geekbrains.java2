package homework3;

import java.util.*;

public class Phonebook {
    Map<String, Set<String>> map = new HashMap<>();

    Set<String> get(String name) {
        return map.getOrDefault(name, new HashSet<>());
    }

    void add(String name, String phone) {
        Set<String> numbers = map.getOrDefault(name, new HashSet<>());
        numbers.add(phone);
        map.put(name, numbers);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
