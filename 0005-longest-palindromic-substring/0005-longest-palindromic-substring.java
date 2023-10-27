class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append(c);
        String str = sb.reverse().toString();
        return LCSubstring(s, str);
    }
    public String LCSubstring(String a, String b) {
        String ans = "";
        int res = 0;
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //Important From Here
                    if (dp[i][j] > res) {
                        String temp = a.substring(i - dp[i][j], i);
                        StringBuilder sb = new StringBuilder(temp);
                        sb.reverse();
                        String reversed = sb.toString();
                        if (temp.equals(reversed)) {
                            ans = temp;
                            res = dp[i][j];
                        }
                    }
                    //To Here
                } else dp[i][j] = 0;
            }
        }
        return ans;
    }
}