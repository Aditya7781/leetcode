class Solution {
    public List<List<Integer>> groupThePeople(int[] gr) {
        int n = gr.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            list.get(gr[i]).add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(list.size()!=0){
                int c = 0;
                while(c<list.get(i).size()){
                    List<Integer> temp = new ArrayList<>();
                    int k = 0;
                    while(k<i){
                        temp.add(list.get(i).get(c));
                        k++;
                        c++;
                    }
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}