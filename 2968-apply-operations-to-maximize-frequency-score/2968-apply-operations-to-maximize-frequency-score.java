class Solution {
    public int maxFrequencyScore(int[] A, long k) {
        int i = 0, res = 0, n = A.length;
        long cur = 0;
        Arrays.sort(A);
        for (int j = 0; j < n; ++j) {
            cur += A[j] - A[(i + j) / 2];
            while (cur > k) {
                cur -= A[(i + j + 1) / 2] - A[i];
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
