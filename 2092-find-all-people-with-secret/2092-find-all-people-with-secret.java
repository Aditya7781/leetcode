class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
      List<List<int[]>> adj=new ArrayList<>();
      for(int i=0;i<n;i++) adj.add(new ArrayList<>());
      for(int[] m:meetings){
        adj.get(m[0]).add(new int[]{m[1],m[2]});
        adj.get(m[1]).add(new int[]{m[0],m[2]});
      }
      Queue<int[]> pq=new PriorityQueue<>((x,y)->x[1]-y[1]);
      pq.add(new int[]{0,0});
      pq.add(new int[]{firstPerson,0});
      boolean vis[]=new boolean[n];
      while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int person=curr[0], time=curr[1];
        if(vis[person]) continue;
        vis[person]=true;
        for(int[] p:adj.get(person)){
          if(!vis[p[0]] && p[1]>=time) pq.add(new int[]{p[0],p[1]});
        }
      }
      List<Integer> al=new ArrayList<>();
      for(int i=0;i<n;i++) if(vis[i]) al.add(i);
      return al;
    }
}