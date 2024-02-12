

class Solution {// Moore Voting Algorithm
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int votes=0;
        int winner_candi=nums[0];
        for(int candidates:nums){
            if(votes==0){
                winner_candi=candidates;
            }
            if(winner_candi==candidates){
                votes++;
            }else{
                votes--;
            }
        }
        return winner_candi;
    }
}

