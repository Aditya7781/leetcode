class Solution {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1; // There's only one way to climb 0 or 1 stairs.
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
