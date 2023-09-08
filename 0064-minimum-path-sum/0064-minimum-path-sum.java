class Solution {
    public int minPathSum(int[][] grid) {
        int memo[][]=new int[grid.length][grid[0].length];
        return minPathSum(grid,0,0,memo);
    }
    private int minPathSum(int[][] grid,int i,int j,int[][] memo){
        if(i>=grid.length || j>=grid[0].length) return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(memo[i][j]>0) return memo[i][j];
        return memo[i][j]=grid[i][j]+Math.min(minPathSum(grid,i+1,j,memo),minPathSum(grid,i,j+1,memo));
    }
}