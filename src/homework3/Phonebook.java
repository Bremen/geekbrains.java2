package homework3;

import java.util.*;

public class Phonebook {
    Map<String, Set<String>> map = new HashMap<>();

    Set<String> get(String name) {
        return map.getOrDefault(name, new HashSet<>());
    }

    void add(String name, String phone) {
        if (!map.containsKey(name)) {
            map.put(name, new HashSet<>());
        }
        map.get(name).add(phone);
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
