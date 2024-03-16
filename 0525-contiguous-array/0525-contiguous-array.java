class Solution {
    public int findMaxLength(int[] nums) {
        int sum =0;
        int maxcount =0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i]==1? 1: -1;
            if(hm.containsKey(sum)){
                maxcount = Math.max(maxcount, i-hm.get(sum));
            }else{
                hm.put(sum,i);
            }
        }
        return maxcount;
    }
}