class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
           arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for(int i = n-1; i>0;i--){
            int diff = arr[i]-arr[i-1];
            max = Math.max(max, diff);
        }
        return max;
    }
}