class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int j = 1;
        
        for(int i = 1; i < n; i++){
            
            int index = binarySearch(dp, 0, j - 1, nums[i]);
            if(index == -1){
                dp[j] = nums[i];
                j++;
            } else{
                dp[index] = nums[i];
            }
        }
        return j;
    }
    
    private int binarySearch(int[] dp, int left, int right, int target){
        
        while(left < right - 1){
            
            int mid = left + (right - left) / 2;
            if(dp[mid] >= target){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        if(dp[left] >= target){
            return left;
        }
        if(dp[right] >= target){
            return right;
        }
        return -1;
    }
}