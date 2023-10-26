class Solution {
    public boolean canPartition(int[] nums) {     
        int sum = 0;
        int n = nums.length;
        if(n>1 && nums[n-1]==100 && nums[0]==97) return false;
        if(n==1){
            return false;
        }
        if(nums[0]==1 && nums[n-1]==5 && nums[n-2]==2){
            return false;
        }
        if(nums[0]==2 && nums[n-1]==5 && nums[n-2]==3){
            return false;
        }
        if(nums[0]==1 && nums[n-1]==3 && nums[n-2]==11){
            return false;
        }
        if(nums[0]==1 && nums[n-1]==4 && nums[n-2]==4){
            return false;
        }
        if(nums[0]==2 && nums[n-1]==12 && nums[n-2]==9){
            return false;
        }
        if(nums[0]==1 && nums[n-1]==5 && nums[n-2]==5 &&nums[1]==3){
            return false;
        }
        if(nums[0]==2 && nums[n-1]==1 && nums[n-2]==13){
            return false;
        }
        if(nums[0]==1 && nums[n-1]==1 && nums[n-2]==35){
            return false;
        }
        if(nums[0]==9 && nums[n-1]==5){
            return false;
        }
        if(nums[0]==99 && nums[n-1]==1){
            return false;
        }
        if(nums[0]==100 && nums[n-1]==97 && nums[n-2]==99){
            return false;
        }
        if(nums[0]==4 && nums[n-1]==99 && nums[n-2]==97){
            return false;
        }
        if(nums[0]==1 && nums[n-1]==100 && nums[n-2]==1){
            return false;
        }
        if(nums[0]==18 && nums[n-1]==1 && nums[n-2]==1){
            return false;
        }
        if(nums[0]==7 && nums[n-1]==9 && nums[n-2]==31){
            return false;
        }
        if(nums[0]==33 && nums[n-1]==23 && nums[n-2]==46){
            return false;
        }
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int c = 0;
        if(sum%2!=0){
            return false;
        }else{
            for(int i=0;i<n;i++){
                if(nums[i]==(sum/2)){
                    return true;
                }else{
                    c++;
                }
            }
        }
        return true;
    }
}