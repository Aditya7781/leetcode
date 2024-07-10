class Solution {
    public boolean isArraySpecial(int[] nums) {

        int n = nums.length;

        if(n == 1){
            return true;
        }

        nums[0] = nums[0]%2;
        for(int i=1; i<n; i++){
            int num = nums[i]%2;
            if(num == nums[i-1]){
                return false;
            }
            nums[i] = num;
        }
        return true; 
    }
}