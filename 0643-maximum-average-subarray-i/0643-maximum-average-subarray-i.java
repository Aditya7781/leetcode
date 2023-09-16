class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        int maxSum = 0;

        for (int i = start; i <= end; i++) {
            maxSum += nums[i];
        }

        double maxAvg = (double) maxSum / k;
        while (end < nums.length - 1) {
            end++;
            maxSum += nums[end];
            maxSum -= nums[start];
            start++;
            double currentAvg = (double) maxSum / k;
            maxAvg = Math.max(maxAvg, currentAvg);
        }

        return maxAvg;
    }
}