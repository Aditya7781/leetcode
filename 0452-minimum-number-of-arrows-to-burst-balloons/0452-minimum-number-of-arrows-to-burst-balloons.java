class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if (a[0]!=b[0]){
                    return Integer.compare(a[0],b[0]);
                }
                else{
                    return Integer.compare(a[1],b[1]);
                }
            }
        });
        int count=1;
        int cur=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>cur){
                count++;
                cur=points[i][1];
            }
            else{
                cur=Math.min(cur,points[i][1]);
            }
        }
        return count;
    }
}