class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
	
        if(nums.length<3) return 0;
        int count=0;
        for(int i=0 ; i<nums.length-2 ; i++)
        {
            if(i+2<nums.length && nums[i+1]-nums[i] == nums[i+2]-nums[i+1])
            {
                int d=nums[i+1] - nums[i];
                count++;
				
                for(int j=i+2;j<nums.length-1 && nums[j+1]-nums[j]==d;j++) count++;
            }
        }
        return count;
    }
}