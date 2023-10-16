class Solution {
    public int[] findIndices(int[] arr, int idxDiff, int diff) {
        int n = arr.length;

        int max = 0;
        int min = 0;

        for(int i=idxDiff; i<n; i++){
            if(arr[i-idxDiff]<arr[min]) min = i-idxDiff;
            if(arr[i-idxDiff]>arr[max]) max = i-idxDiff;

            if(arr[i]-arr[min]>=diff) return new int[]{min,i};
            if(arr[max]-arr[i]>=diff) return new int[]{max,i};
        }
        return new int[]{-1,-1};
    }
}