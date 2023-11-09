class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] memo = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        return lcsMemo(text1, text2, n, m, memo);
    }

    private int lcsMemo(String text1, String text2, int n, int m, int[][] memo) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (memo[n][m] != -1) {
            return memo[n][m];
        }

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            memo[n][m] = 1 + lcsMemo(text1, text2, n - 1, m - 1, memo);
        } else {
            int option1 = lcsMemo(text1, text2, n - 1, m, memo);
            int option2 = lcsMemo(text1, text2, n, m - 1, memo);
            memo[n][m] = Math.max(option1, option2);
        }

        return memo[n][m];
    }
}
