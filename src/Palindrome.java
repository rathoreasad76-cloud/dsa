public class Palindrome {

    public boolean isPalindrome(String str) {
        String trimmed = str.trim().toLowerCase().replaceAll(" ","").replaceAll("[^a-z0-9]", "");
        String reversed = reverse(trimmed);
        return reversed.equals(trimmed);
    }

    public String reverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    public boolean isValidPalindromeWithNoExtraSpace(String str) {
        String trimmed = str.trim().replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = trimmed.length() - 1;
        while (left < right) {
            if (trimmed.charAt(left) != trimmed.charAt(right)) { return false;}
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
