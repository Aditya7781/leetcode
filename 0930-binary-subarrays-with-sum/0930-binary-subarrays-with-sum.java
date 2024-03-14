class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        int[] prefixSumCount = new int[nums.length + 1];
        prefixSumCount[0] = 1;
        
        for (int num : nums) {
            sum += num;
            if (sum >= goal) {
                count += prefixSumCount[sum - goal];
            }
            prefixSumCount[sum]++;
        }
        
        return count;
    }
}
