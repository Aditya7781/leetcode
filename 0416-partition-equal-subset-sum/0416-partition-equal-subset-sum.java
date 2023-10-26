class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            sum = sum + nums[i];
        }
        if(sum % 2 != 0){
            return false;
        } else {
            return subsetSum(n,nums,sum/2);
        }
    }
    public boolean subsetSum(int N, int arr[], int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];
        
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[N][sum];
    }
}