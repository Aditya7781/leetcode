class Solution {
    public int maxProfit(int[] prices, int fee) {
    if (prices == null || prices.length == 0) {
        return 0;
    }
    
    int n = prices.length;
    int buy = -prices[0];
    int sell = 0;
    
    for (int i = 1; i < n; i++) {
        int prevBuy = buy;
        int prevSell = sell;
        
        buy = Math.max(prevBuy, prevSell - prices[i]);
        sell = Math.max(prevSell, prevBuy + prices[i] - fee);
    }
    
    return sell;
}
}