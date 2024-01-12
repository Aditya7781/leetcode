import java.util.*;
class Solution {
    public int numOfPairs(String[] nums, String target) {

        HashMap<String,Integer> map = new HashMap<>();

        for(int i =0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
            
        }
        int count = 0;
        for(int i =0; i<nums.length ; i++)
        {
            String curr = nums[i];
            if(curr.length() > target.length())
            {
                continue;
            }
            String prefix = target.substring(0,curr.length());

            if(prefix.equals(curr)) {
                String suffix = target.substring(curr.length(), target.length());
                if(map.containsKey(suffix))
                {
                    if(prefix.equals(suffix))
                    {
                        count += map.get(suffix) -1;
                    }else
                    {
                        count += map.get(suffix);
                    }
                    
                }
            }
        }
        

        return count;

        
    }
}