class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();
        for (int i : nums) {
            s.add(i);
        }

        int res = 0;

        for (int i : s) {
            if (i > k) {
                res++; 
            } else if (i < k) {
                return -1; 
            }
        }

        return res;
    }
}