class Solution {
    public int minCut(String s) {
        int n=s.length();
        
        int dp[][]=new int[n+1][n+1];
            for(int j[]:dp)
                Arrays.fill(j,-1);
        
        return helper(s,0,n,dp);
    }
    
     public int helper(String s,int i,int j,int dp[][])
    {
        if(i>j)
            return 100000;
        
        if(i==j)
            return 0;   
          
         
         if(isPalin(s,i,j-1))
         {
            return 0;     
         }
        
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
         int mc=Integer.MAX_VALUE;
        for(int t=i;t<j;t++)
        {
         
            if(isPalin(s,i,t))
            {
                mc=Math.min(1+ helper(s,t+1,j,dp),mc);
            }
            
        }
        dp[i][j]= mc;
        
        return dp[i][j];
    }
 
    boolean isPalin(String s,int i,int j)
    {
        if(i>j)
            return false;
        
        if(i==j)
            return true;
        
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    
}
