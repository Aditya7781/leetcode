class Solution {
    public int countNicePairs(int[] nums) {
        final int MOD = 1_000_000_007;
        int count = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            int difference = num - reverse(num);
            count = (count + frequencyMap.getOrDefault(difference, 0)) % MOD;
            frequencyMap.put(difference, frequencyMap.getOrDefault(difference, 0) + 1);
        }

        return count;
    }

    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
