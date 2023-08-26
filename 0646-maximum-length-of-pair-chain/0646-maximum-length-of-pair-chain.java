class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = pairs.length;
        int omax = 0;
        int[] dp = new int[n];
        
        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            
            dp[i] = max + 1;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }
        
        return omax;
    }
}
