class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if(n == 0) return 0;
        if(n == 1) return 1;

        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);

        int ans = 0;
        int curr = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(pairs[i][0] > curr){
                ans++;
                curr = pairs[i][1];
            }
        }

        return ans;
    }
}