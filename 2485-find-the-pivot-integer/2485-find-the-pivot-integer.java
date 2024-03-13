class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        int total = n*(n+1) / 2;
        int low = 1, high = n;
        while(low <= high) {
            int pivot = (low+high) / 2;
            int prefixSum = pivot*(pivot+1) / 2;
            int suffixSum = total - prefixSum + pivot;
            if(prefixSum == suffixSum) return pivot;
            else if(prefixSum < suffixSum) low = pivot + 1;
            else high = pivot - 1;
        }
        return -1;
    }
}