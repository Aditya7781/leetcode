class Solution {
    public int specialArray(int[] nums) {
        int size = nums.length;
        int[] hash = new int[size + 1];

        for (int i : nums) {
            if (i > size) {
                hash[size]++;
            } else {
                hash[i]++;
            }
        }

        int ans = 0;

        for (int i = size; i > 0; i--) {
            ans += hash[i];

            if (ans == i) {
                return i;
            }

            if (ans > i) {
                return -1;
            }
        }

        return -1;
    }
}