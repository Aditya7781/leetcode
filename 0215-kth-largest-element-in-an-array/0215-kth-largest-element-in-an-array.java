class Solution {
    // Priority Queue O(n*log(k))
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> heap = new PriorityQueue<>();
    //     for (int n : nums) {
    //         heap.add(n);
    //         if (heap.size() > k) {
    //             heap.remove();
    //         }
    //     }
    //     return heap.peek();
    // }

    // Quick Select O(n) on average
    // public int findKthLargest(int[] nums, int k) {
    //     List<Integer> numList = new ArrayList<>();
    //     for (int n : nums) numList.add(n);

    //     return quickSelect(numList, k);
    // }

    // private int quickSelect(List<Integer> nums, int k) {
    //     int pivotIdx = new Random().nextInt(nums.size());
    //     int pivot = nums.get(pivotIdx);

    //     List<Integer> left = new ArrayList<>();
    //     List<Integer> mid = new ArrayList<>();
    //     List<Integer> right = new ArrayList<>();
    //     for (int n : nums) {
    //         if (n > pivot) {
    //             left.add(n);
    //         } else if (n == pivot) {
    //             mid.add(n);
    //         } else {
    //             right.add(n);
    //         }
    //     }
    //     if (left.size() >= k) {
    //         return quickSelect(left, k);
    //     }
    //     if ((left.size() + mid.size()) < k) {
    //         return quickSelect(right, k - left.size() - mid.size());
    //     }

    //     return pivot;
    // }
    public int findKthLargest(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        for (int num: nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        
        int[] count = new int[maxValue - minValue + 1];
        for (int num: nums) {
            count[num - minValue]++;
        }
        
        int remain = k;
        for (int num = count.length - 1; num >= 0; num--) {
            remain -= count[num];
            if (remain <= 0) {
                return num + minValue;
            }
        }
        
        return -1;
    }
}