class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0;
        int maxSoFar = 0;

        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
