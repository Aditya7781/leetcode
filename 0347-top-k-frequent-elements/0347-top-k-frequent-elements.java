class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        int[] counter = new int[max - min + 1];
        for (int num : nums) {
            counter[num - min]++;
        }
        
        for (int idx = 0; idx < counter.length; idx++) {
            if (counter[idx] > 0) {
                int val = idx + min;
                int freq = counter[idx];
                if (bucket[freq] == null) {
                    bucket[freq] = new ArrayList<Integer>();
                }
                bucket[freq].add(val);
            }
        }

        int index = 0;
        int[] res = new int[k];
        int ptr = nums.length;
        while (index < k) {
            if (bucket[ptr] != null) {
                for (int val : bucket[ptr]) {
                    res[index++] = val;
                    if (index == k) {
                        return res;
                    }
                }
            }
            ptr--;
        }
        
        return res;
    }
}