class Solution {

    private int MOD = (int)1e9 + 7;

    public int countOrders(int numPairs) {
        long[] dp = new long[numPairs + 1];

        dp[0] = 1;

        for (int currentPairs = 1; currentPairs <= numPairs; currentPairs++) {
            dp[currentPairs] = dp[currentPairs - 1] * (2 * currentPairs - 1) * currentPairs % MOD;
        }

        return (int)dp[numPairs];
    }
}