package blind75;

import java.util.Stack;

public class validParantheses {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char pop = stack.pop();
                    ;
                    if (pop == '(' && chars[i] != ')') {
                        return false;
                    }
                    if (pop == '[' && chars[i] != ']') {
                        return false;
                    }
                    if (pop == '{' && chars[i] != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        validParantheses s = new validParantheses();
        System.out.println(s.isValid("({}[]()[{}{()}])"));
        System.out.println(s.isValid("([)]"));


    }
}
