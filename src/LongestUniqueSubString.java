import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubString {

    public int longestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>( );
        int len = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                set.clear();
                i = start;
                start++;
            }
            len = Math.max(len, set.size());
        }

        return len;
    }

    public int longestUniqueSubString(String s) {
        int len = s.length();

        return len;
    }

    public static void main(String[] args) {
        LongestUniqueSubString logestSubString = new LongestUniqueSubString();
        String s = "dvdf";//"anviaj,abcabcbb-xyxyzab";
        System.out.println("; length : "+logestSubString.longestSubString(s));
    }
}
