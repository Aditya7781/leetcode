class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 3) {
            if (i + 2 < nums.length && nums[i + 2] - nums[i] > k) {
                return new int[0][];
            }

            List<Integer> subarray = new ArrayList<>();
            subarray.add(nums[i]);

            if (i + 1 < nums.length) {
                subarray.add(nums[i + 1]);
            }

            if (i + 2 < nums.length) {
                subarray.add(nums[i + 2]);
            }

            result.add(subarray);
        }

        int[][] resultArray = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> subarray = result.get(i);
            for (int j = 0; j < subarray.size(); j++) {
                resultArray[i][j] = subarray.get(j);
            }
        }

        return resultArray;
    }
}