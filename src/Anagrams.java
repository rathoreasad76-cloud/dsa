import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {

    public boolean  isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }  else {
            HashMap<Character, Integer> mapA = new HashMap<Character, Integer>();
            for (int i=0; i<a.length(); i++) {
                mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0) + 1);
            }
            HashMap<Character, Integer> mapB = new HashMap<Character, Integer>();
            for (int i=0; i<b.length(); i++) {
                mapB.put(b.charAt(i), mapB.getOrDefault(b.charAt(i), 0) + 1);
            }
            if (mapA.size() != mapB.size()) {
                return false;
            } else  {
                for (Character key : mapA.keySet()) {
                    if (!mapB.containsKey(key) || !mapB.get(key).equals(mapA.get(key))) {
                        return false;
                    }
                }
            }

        }
        return true;
    }



    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.isAnagram2("listen", "silent"));
        System.out.println(anagrams.isAnagram2("hello", "world"));
        System.out.println(anagrams.isAnagram2("triangle", "integral"));
        System.out.println(anagrams.isAnagram2("apple", "pabble"));
        System.out.println(anagrams.isAnagram2("aacc", "ccac"));
        System.out.println("-------------   isAnagram2  ----------------------");
        anagrams.isAnagram2("listen", "silent");

        anagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(System.out::println);
    }

    /**
     * Map which has keys as characters for both words:
     * for one word character count is increamented and for the other word character count is decremented. If all counts
     * are 0, then they are anagrams.
     * @param a
     * @param b
     * @return
     */
    public boolean isAnagram2(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            counts.merge(a.charAt(i),  1, Integer::sum);
            counts.merge(b.charAt(i), -1, Integer::sum);
        }
        //counts.forEach((k, v) -> System.out.println("k: " + k + " v: " + v));
        return counts.values().stream().allMatch(v -> v == 0);
    }

    public List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            String actualWord = word;
            char groupWordCharArray[] = word.toCharArray();
            Arrays.sort(groupWordCharArray);
            String groupWord = new String(groupWordCharArray);
            map.computeIfAbsent(groupWord, k -> new ArrayList<>()).add(actualWord);
        });
        return map.values().stream().toList();
    }

    public List<List<String>> groupAnagrams2(String[] words) {
        return new ArrayList<>(
                Arrays.stream(words)
                        .collect(Collectors.groupingBy(word -> {
                            char[] chars = word.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }))
                        .values()
        );
    }
}
