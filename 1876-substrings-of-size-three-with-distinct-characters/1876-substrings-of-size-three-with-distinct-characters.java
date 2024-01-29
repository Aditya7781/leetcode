class Solution {
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            String substring = s.substring(i, i + 3);
            if (hasDistinctCharacters(substring)) {
                count++;
            }
        }

        return count;
    }

    private boolean hasDistinctCharacters(String str) {
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!set.add(ch)) {
                return false;
            }
        }

        return true;
    }
}
