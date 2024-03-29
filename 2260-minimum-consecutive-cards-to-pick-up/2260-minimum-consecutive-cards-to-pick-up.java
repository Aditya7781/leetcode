class Solution {
    public int minimumCardPickup(int[] cards) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<cards.length;i++){
            if(hm.containsKey(cards[i])){
                int l=hm.get(cards[i]);
                min=Math.min(min,i-l+1);
            }
            hm.put(cards[i],i);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}