class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (containsCharacter(words[i], x)) {
                result.add(i);
            }
        }
        return result;
        
    }
    private boolean containsCharacter(String word, char x) {
        for (char c : word.toCharArray()) {
            if (c == x) {
                return true;
            }
        }
        return false;
    }
}