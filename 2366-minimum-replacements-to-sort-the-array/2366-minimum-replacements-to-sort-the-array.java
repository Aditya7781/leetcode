class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;

        if (n == 1) return 0;

        return f(n-1, nums, 0, n);
    }

    static long f(int index, int[] nums, int min, int n) {
        // System.out.println(min);

        if (index == n-1) {
            return f(index - 1, nums, nums[index], n);
        } else {
            int ec = 0;
            if (nums[index] > min) {
                // minimum number of parts with each P_i <= min
                if (nums[index] % min == 0) {
                    ec = nums[index]/min;
                } else {
                    ec = nums[index]/min + 1;
                }

                int nmin = nums[index]/ec;
                long lc = ec;

                if (index == 0) {
                    return lc - 1;
                } else {
                    return lc - 1 + f(index - 1, nums, nmin, n); 
                }

            } else {
                if (index == 0) {
                    return 0;
                } else {
                    return f(index-1, nums, nums[index], n);
                }
            }

        }
    }
}