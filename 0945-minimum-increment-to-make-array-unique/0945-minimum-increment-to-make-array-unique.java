class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n=nums.length;
        int p1=0;
        int p2=0;
        int ans=0;
        int ct[]=new int[1000000];
        for(int i:nums) ct[i]++;

        for(int i=1;i<1000000;i++){
            if(ct[i]==0){
                p2=i;
                break;
            }
        }
        for(int i=0;i<1000000;i++){
            if(p2<i) p2=i+1;
            while(ct[i]>1){
                while(p2<100000 && ct[p2]>0){
                    p2++;
                }
                ans+=p2-i;
                ct[p2]++;
                ct[i]--;
                if(p2<=i) p2=i+1;
            }
        }
        return ans;
    }
}