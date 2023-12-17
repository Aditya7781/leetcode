class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
         HashMap<Integer,Integer> hm=new HashMap<>();
        int i;
        for(i=0;i<=grid.length*grid.length;i++) hm.put(i,0);
        for(i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                hm.put(grid[i][j], hm.getOrDefault(grid[i][j],0)+1);
            }
        }
        int a=0,b=0;
        for(Map.Entry<Integer,Integer> en:hm.entrySet()){
            if(en.getValue() > 1) a=en.getKey();
            if(en.getValue() == 0) b=en.getKey();
        }
        return new int[]{a,b};
    }
}