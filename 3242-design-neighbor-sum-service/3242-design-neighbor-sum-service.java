class neighborSum {
    HashMap<Integer,Integer> map1=new HashMap<>();
     HashMap<Integer,Integer> map2=new HashMap<>();
    public neighborSum(int[][] grid) {
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int top=0;
                int bottom=0;
                int left=0;
                int right=0;
                int lt=0;
                int rt=0;
                int ll=0;
                int rl=0;
                if(i>0)top=grid[i-1][j];
                if(j>0)left=grid[i][j-1];
                if(i<grid.length-1)bottom=grid[i+1][j];
                if(j<grid.length-1)right=grid[i][j+1];
                if(i>0 && j>0)lt=grid[i-1][j-1];
                if(j>0 && i<grid.length-1)ll=grid[i+1][j-1];
                if(i<grid.length-1 && j<grid.length-1)rl=grid[i+1][j+1];
                if(j<grid.length-1 && i>0)rt=grid[i-1][j+1];
                map1.put(grid[i][j],top+left+right+bottom);
                map2.put(grid[i][j],lt+ll+rt+rl);
            }
        }
    }
    
    public int adjacentSum(int value) {
        return map1.get(value);
    }
    
    public int diagonalSum(int value) {
         return map2.get(value);
    }
}
/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */