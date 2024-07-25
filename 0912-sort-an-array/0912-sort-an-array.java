class Solution {
    public int[] sortArray(int[] nums) {
        int max = getMax(nums);
        int min = getMin(nums);
        int range = max - min + 1;

        int[] count = new int[range];
        for (int num : nums) {
            count[num - min]++;
        }

        int[] sortedNums = new int[nums.length];
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                sortedNums[index++] = i + min;
            }
        }

        return sortedNums;
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private int getMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}