class Solution {
    public int minOperations(int[] nums, int k) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        int targetXOR = xorSum ^ k;
        int operationCount = 0;
        while (targetXOR != 0) {
            operationCount += targetXOR & 1;
            targetXOR >>= 1;
        }
        return operationCount;
    }
}
