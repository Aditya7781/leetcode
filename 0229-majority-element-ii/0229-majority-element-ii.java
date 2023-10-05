class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 1;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                count++;
            } else {
                if (count > n / 3) {
                    result.add(nums[i]);
                }
                count = 1;
            }
        }

        if (count > n / 3) {
            result.add(nums[n - 1]);
        }

        return result;
    }
}