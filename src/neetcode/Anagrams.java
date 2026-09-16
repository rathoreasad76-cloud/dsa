package neetcode;

import java.util.Arrays;

public class Anagrams {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char sArray [] = s.toCharArray();
        char tArray [] = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Anagrams    anagrams = new Anagrams();
        System.out.println(anagrams.isAnagram("listen", "silent"));
        System.out.println(anagrams.isAnagram("hello", "world"));
        System.out.println(anagrams.isAnagram("triangle", "integral"));
        System.out.println(anagrams.isAnagram("apple", "pabble"));
        System.out.println(anagrams.isAnagram("aacc", "ccac"));
        System.out.println(anagrams.isAnagram("racecar", "carrace"));
    }
}
