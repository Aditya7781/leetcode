class Solution {
     int LCS(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int LPS(String s) {
        StringBuilder r = new StringBuilder(s);
        r.reverse();
        int n = s.length();
        return LCS(s, r.toString(), n, n);
    }
    //int minDeletions(String str, int n) 
    //{
    //    return n - LPS(str);
    //}
    public int minInsertions(String s) {
        int n = s.length();
        return n - LPS(s);//no. of insertions is same as deletions
    }
}