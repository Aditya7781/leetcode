class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr,(a,b)->(a[0]-b[0]));
        ArrayList<int[]> a = new ArrayList<>();
        a.add(arr[0]);
        for(int i=1; i<n; i++){
            int x[] = a.get(a.size()-1);
            if(arr[i][0]>x[1]){
                a.add(arr[i]);
            }else{
                a.get(a.size()-1)[1] = Math.max(x[1],arr[i][1]);
            }
        }
        int ans[][] = new int[a.size()][2];
        for(int i=0; i<a.size(); i++){
            ans[i] = a.get(i);
        }
        return ans;
    }
}