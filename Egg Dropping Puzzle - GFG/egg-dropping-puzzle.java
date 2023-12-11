//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution {
    static int[][] dp;

    static int eggDrop(int n, int k) {
        dp = new int[n + 1][k + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return solve(n, k);
    }

    static int solve(int e, int f) {
        if (e == 1) return f;
        if (f == 0 || f == 1) return f;

        if (dp[e][f] != -1) return dp[e][f];
        int ans = Integer.MAX_VALUE;

        int left = 1, right = f;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int low = solve(e - 1, mid - 1);
            int high = solve(e, f - mid);

            int temp = 1 + Math.max(low, high);
            ans = Math.min(ans, temp);

            if (low < high) left = mid + 1;
            else right = mid - 1;
        }

        return dp[e][f] = ans;
    }
}