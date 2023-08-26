import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];
        int maxSubsetSize = 0;
        int maxSubsetIndex = -1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > maxSubsetSize) {
                maxSubsetSize = dp[i];
                maxSubsetIndex = i;
            }
        }

        List<Integer> largestSubset = new ArrayList<>();
        while (maxSubsetIndex != -1) {
            largestSubset.add(nums[maxSubsetIndex]);
            maxSubsetIndex = parent[maxSubsetIndex];
        }

        return largestSubset;
    }
}
