class Solution {
    public List<List<Integer>> generate(int n) {

         List<List<Integer>> ans= new ArrayList<>();
         
         List<Integer> li = new ArrayList<>();
         li.add(1);
         ans.add( new ArrayList<>(li));
         if(n==1) return ans;

         for(int i =1;i<n;i++)
         {
             List<Integer> ll = new ArrayList<>();
             int l ,r;
             for(int j=0;j<=i;j++)
             {
                 l=0;r=0;
                 
                 if(j-1>=0) l=ans.get(i-1).get(j-1);
                 if(j<=i-1) r=ans.get(i-1).get(j);
                 ll.add(l+r);
             }
             ans.add(new ArrayList<>(ll));
         }
             
      return ans;
    }
}