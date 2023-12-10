class Solution {
    private int[] dp;

    public int solve(String s, int i, int n) {
        if (s.length() == 0) {
            return 1;
        }
        if (s.length() == 1) {
            if (Integer.parseInt(s) != 0 && Integer.parseInt(s) <= 26) {
                return 1;
            }
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        String a = s.substring(0, 1);
        String b = s.substring(0, 2);

        if (Integer.parseInt(a) == 0 || Integer.parseInt(a) > 26) {
            return 0;
        }
        int x = 0, y = 0;
        if (Integer.parseInt(a) <= 26) {
            s = s.substring(1);
            x = solve(s, i + 1, n);
            s = a + s;
        }
        if (Integer.parseInt(b) <= 26) {
            s = s.substring(2);
            y = solve(s, i + 2, n);
            s = b + s;
        }
        return dp[i] = x + y;
    }

    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(s, 0, n);
    }
    
}