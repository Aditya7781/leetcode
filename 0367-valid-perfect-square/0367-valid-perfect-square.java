class Solution {
    public boolean isPerfectSquare(int n) {
        if(n==1)return true;
        long s=0,e=n/2;
        while(s<=e){
            long m=s+(e-s)/2;
            long sq=m*m;
            if(sq==n)return true;
            else if(sq>n)e=m-1;
            else s=m+1;
        }
        return false;
    }
}