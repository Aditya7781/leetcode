class Solution {
    public int minOperations(int[] nums, int x) {
    int n = nums.length;
    int targetSum = Arrays.stream(nums).sum() - x;

    if (targetSum < 0) {
        return -1;
    }

    int left = 0;
    int sum = 0;
    int minOps = Integer.MAX_VALUE;

    for (int right = 0; right < n; right++) {
        sum += nums[right];

        while (sum > targetSum) {
            sum -= nums[left];
            left++;
        }

        if (sum == targetSum) {
            int ops = (n - 1 - right) + left;
            minOps = Math.min(minOps, ops);
        }
    }

    return minOps == Integer.MAX_VALUE ? -1 : minOps;
}
}