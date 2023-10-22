class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int maxScore = nums[k]; 
        int minVal = nums[k];
        int left = k, right = k;

        while (left > 0 || right < n - 1) {
            if (left == 0) {
                right++;
            } else if (right == n - 1) {
                left--;
            } else if (nums[left - 1] < nums[right + 1]) {
                right++;
            } else {
                left--;
            }
            minVal = Math.min(minVal, Math.min(nums[left], nums[right]));
            int currentScore = minVal * (right - left + 1);
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
}