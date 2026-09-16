package problems;

import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new java.util.LinkedHashMap<>();
        map.put(1, "1");
        map.computeIfAbsent(2, k -> k+": 2:updated");
        map.entrySet().forEach(entry -> System.out.println("{" + entry.getKey() + ": " + entry.getValue() + "}"));
    }
}
