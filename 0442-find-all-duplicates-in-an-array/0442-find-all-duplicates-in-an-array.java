class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) +1);
        } 
        
        for(int key : map.keySet()){
            if(map.get(key) >= 2){
                ans.add(key);
            }
        }
        return ans;
    }
}