class Solution {
    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        int count = 1;
        int consecutive = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                consecutive++;
            } else {
                consecutive = 1;
            }

            count = (count + consecutive) % MOD;
        }

        return count;
    }
}
