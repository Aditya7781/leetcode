class Solution {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = nums[n/2], right = nums[n/2];
        while(!isPalindromic(left)) left--;
        while(!isPalindromic(right)) right++;
        return Math.min(cost(nums, left), cost(nums, right));
    }

    private long cost(int[] nums, int target) {
        long cost = 0;
        for (int num : nums) {
            cost += Math.abs(num - target);
        }
        return cost;
    }

    private boolean isPalindromic(int num) {
        int originNum = num;
        int reverseNum = 0;
        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            reverseNum = reverseNum * 10 + digit;
        }
        return reverseNum == originNum;
    }

}