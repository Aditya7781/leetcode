class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if( m+n != s3.length()) return false;
        return helper(0,0,s1,s2,s3,new Boolean[m+1][n+1]);
    }
    
    private boolean helper(int i, int j, String s1, String s2, String s3, Boolean[][] dp){
        if(i==s1.length() && j==s2.length()) return dp[i][j]=true;
        
        if(dp[i][j]!=null) return dp[i][j];
    
        if(i<s1.length() && s1.charAt(i)==s3.charAt(i+j)){
            boolean ans = helper(i+1,j,s1,s2,s3,dp);
            dp[i][j] = ans;
            if(ans==true) return true;
        }
        
        if(j<s2.length() && s2.charAt(j)==s3.charAt(i+j)){
            boolean ans = helper(i,j+1,s1,s2,s3,dp);
            dp[i][j] = ans;
            if(ans==true) return true;
        }
        
        return dp[i][j] = false;
    }
}