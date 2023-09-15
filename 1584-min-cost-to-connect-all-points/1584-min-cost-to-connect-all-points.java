class Solution {
    public int dis(int[] point1, int[] point2){
        return Math.abs(point1[0]-point2[0]) + Math.abs(point1[1]-point2[1]);
    }
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] visited = new int[n];
        Arrays.fill(visited,0);
        int[] minCost = new int[n];
        Arrays.fill(minCost,Integer.MAX_VALUE);
        int curr = 0;
        minCost[0] = 0;
        int ans = 0;
        
        while(curr>=0){
            visited[curr]=1;
            int nextPoint=-1;
            int minCurr = Integer.MAX_VALUE;
            
            for(int point = 0;point<n;point++){
                if(visited[point]==1 || curr==point){
                    continue;
                }
                minCost[point] = Math.min(dis(points[curr],points[point]),minCost[point]);
                
                if(minCost[point]<minCurr){
                    minCurr = minCost[point];
                    nextPoint = point;
                }
            }
            if(minCurr==Integer.MAX_VALUE){
                    ans+=0;
                } else{
                    ans+=minCurr;
                }
                curr = nextPoint;
        }
        return ans;
    }
}