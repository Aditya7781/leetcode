class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashSet<Integer> all=new HashSet<>();
        HashSet<Integer> loosers=new HashSet<>();
        HashMap<Integer,Integer> losses=new HashMap<>();
        
        for(int match[] : matches){
            int w=match[0];
            int l=match[1];
            
            all.add(w);
            all.add(l);
            loosers.add(l);
            losses.put(l,losses.getOrDefault(l,0)+1);
        }
        
        List<Integer> winners=new ArrayList<>();
        List<Integer> oneTimeLoosers=new ArrayList<>();
        
        for(int player:all){
            if(!loosers.contains(player)) 
                winners.add(player);
        }
        
        for(int looser:losses.keySet()){
            if(losses.get(looser)==1)
                oneTimeLoosers.add(looser);
        }
        
        Collections.sort(winners);
        Collections.sort(oneTimeLoosers);
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(winners);
        ans.add(oneTimeLoosers);
        
        return ans;
    }
}