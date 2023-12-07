class Solution {
    public int minCut(String s) {
        int n = s.length();
        
        // dp[i] represents the minimum cuts needed for the substring s[0:i]
        int[] dp = new int[n];
        
        // Initialize dp array with worst-case values
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }
        
        // Check for palindromes centered at each character and update dp array
        for (int center = 0; center < n; center++) {
            expandAroundCenter(s, center, center, dp);
            expandAroundCenter(s, center, center + 1, dp);
        }
        
        return dp[n - 1];
    }

    private void expandAroundCenter(String s, int left, int right, int[] dp) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                dp[right] = 0;  // The whole substring is a palindrome
            } else {
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}