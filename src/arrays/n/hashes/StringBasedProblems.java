package arrays.n.hashes;

public class StringBasedProblems {

    public static void main(String[] args) {
        // Test the buddyStrings method
        StringBasedProblems sbp = new StringBasedProblems();
        String s = "ab";
        String goal = "ab";
        boolean result = sbp.buddyStrings(s, goal);
        System.out.println(result);

        // Test the areOccurrencesEqual method
        String s2 = "aabbc";
        boolean result2 = sbp.areOccurrencesEqual(s2);
        System.out.println(result2);

    }


    public boolean buddyStrings (String s, String goal) {

        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                if (count[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }

        if (s.length() != goal.length()) {
            return false;
        }
        int count = 0;
        int indexS = -1;
        int indexG = -1;
        for (int i =0; i<s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (indexS == -1) {
                    indexS = i;
                } else if (indexG == -1) {
                    indexG = i;
                }
            }
        }
        return count == 2 && s.charAt(indexS) == goal.charAt(indexG) && s.charAt(indexG) == goal.charAt(indexS);
    }

     public boolean areOccurrencesEqual(String s) {

        int [] freq = new int [26];    
        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;        
        }

        for (int i=0; i< freq.length-1; i++) {
            if (freq[i] > 0 && freq[i+1] > 0 && freq[i] != freq[i+1]) {
                return false;
            }
        }
        return true;

    }
}
