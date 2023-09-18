class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int strengthA = a[0];
            int strengthB = b[0];
            if (strengthA != strengthB) {
                return Integer.compare(strengthA, strengthB);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int soldiersCount = Arrays.stream(mat[i]).sum(); // Count soldiers in the row
            // Push [strength, index] array to min heap
            minHeap.offer(new int[]{-soldiersCount, -i});

            // If the size of the heap exceeds k, remove the row with the highest strength
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Retrieve the indices of the k weakest rows in order
        int[] weakestRows = new int[k];
        int index = k - 1;
        while (!minHeap.isEmpty()) {
            weakestRows[index--] = -minHeap.poll()[1];
        }

        return weakestRows;        
    }
}