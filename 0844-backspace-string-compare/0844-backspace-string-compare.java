import java.util.Stack;

class Solution {
    public String convert(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        String s1 = convert(s);
        String s2 = convert(t);
        return s1.equals(s2);
    }
}
