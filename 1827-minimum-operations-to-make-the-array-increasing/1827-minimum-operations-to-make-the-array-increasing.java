class Solution {
    public int minOperations(int[] nums) {
    int n = nums.length;
    
    int prevMax = 0;
    int operations = 0;
    
    for (int i = 0; i < n; i++) {
        if (nums[i] <= prevMax) {
            int increment = prevMax - nums[i] + 1;
            nums[i] += increment;
            operations += increment;
        }
        
        prevMax = nums[i];
    }
    
    return operations;
}
}