class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int n = word.length();
        int ans = 0;
        StringBuilder modifiedWord = new StringBuilder(word);

        for (int i = 1; i < n; i++) {
            if (modifiedWord.charAt(i) == modifiedWord.charAt(i - 1) || 
                Math.abs(modifiedWord.charAt(i) - modifiedWord.charAt(i - 1)) == 1) {
                
                modifiedWord.setCharAt(i, '.');
                ans++;
            }
        }

        return ans;
    }
}
