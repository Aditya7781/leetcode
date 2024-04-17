class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        
        for (int i = left; i <= right; i++) {
            if (isVowelString(words[i])) {
                count++;
            }
        }
        
        return count;
    }
    
    private boolean isVowelString(String word) {
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);
        
        return isVowel(firstChar) && isVowel(lastChar);
    }
    
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
