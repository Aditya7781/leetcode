public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int basic;
        int sum = 0;
        if(n%2 == 0) basic =n/2;   
        else basic = (n+1)/2;
        for(int i=0;i<n;++i)
        {
            sum = sum + basic - nums[i];
        }
        if(n%2 == 0) sum += basic;
        return sum;
    }
}