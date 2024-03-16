import java.util.*;

class Solution {
    public String minimizeStringValue(String s) {
        TreeSet<Pair> set = new TreeSet<>(Comparator.comparing(Pair::getCount).thenComparing(Pair::getCharacter));
        
        for (char c = 'a'; c <= 'z'; c++) {
            set.add(new Pair(countOccurrences(s, c), c));
        }
        
        List<Integer> questionIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                questionIndices.add(i);
            }
        }
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                Pair pair = set.first();
                chars[i] = pair.getCharacter();
                set.remove(pair);
                set.add(new Pair(pair.getCount() + 1, pair.getCharacter()));
            }
        }
        
        List<Character> questionChars = new ArrayList<>();
        for (int index : questionIndices) {
            questionChars.add(chars[index]);
        }
        
        Collections.sort(questionChars);
        
        for (int i = 0; i < questionChars.size(); i++) {
            chars[questionIndices.get(i)] = questionChars.get(i);
        }
        
        return new String(chars);
    }
    
    private int countOccurrences(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) {
                count++;
            }
        }
        return count;
    }
    
    class Pair {
        private int count;
        private char character;
        
        public Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
        
        public int getCount() {
            return count;
        }
        
        public char getCharacter() {
            return character;
        }
    }
    
}
