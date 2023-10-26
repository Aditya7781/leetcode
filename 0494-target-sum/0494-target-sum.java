class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;

    // Calculate the total sum of the elements in the nums array.
    for (int num : nums) {
        sum += num;
    }

    /// Check if it's possible to find a subset with a sum of 'target'.
    if (Math.abs(target) > sum || (sum + target) % 2 == 1) {
        return 0;
    }
    
    int newTarget = (sum + target) / 2;

    int[] dp = new int[newTarget + 1];
    dp[0] = 1;

    for (int num : nums) {
        for (int currSum = newTarget; currSum >= num; currSum--) {
            dp[currSum] += dp[currSum - num];
        }
    }

    return dp[newTarget];
}

    public int recFun(int[] nums, int currSum, int target, int currIndex) {
        
        if (currIndex == nums.length) {
            // If we've reached the last element in the array, check if currSum matches the target.
            return currSum == target ? 1 : 0;
        }

        // Calculate the number of ways by adding and subtracting the current number.
        int plus = recFun(nums, currSum + nums[currIndex], target, currIndex + 1);
        int minus = recFun(nums, currSum - nums[currIndex], target, currIndex + 1);

        return plus + minus;
    }
}