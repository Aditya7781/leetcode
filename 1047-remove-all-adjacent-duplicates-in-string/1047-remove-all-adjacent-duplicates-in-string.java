class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == stack.get(count)) {
                stack.pop();
                if (count!=0) count--;
            } else {
                stack.push(s.charAt(i));
                count++;
            }
        }

        for (Character character : stack) {
            stb.append(character);
        }

        return stb.toString();
    
    }
}