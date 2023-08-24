class Solution {
    public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
        return 0;
    }
    
    int n = prices.length;
    int[] dp = new int[n];
    
    int minPrice = prices[0];
    
    for (int i = 1; i < n; i++) {
        dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
        minPrice = Math.min(minPrice, prices[i]);
    }
    
    return dp[n - 1];
}
}