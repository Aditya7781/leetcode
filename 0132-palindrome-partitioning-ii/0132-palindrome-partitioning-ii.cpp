class Solution {
public:
    int minCut(string s) {
        int n = s.size();

        if (n == 1)
        {
            return 0;
        }

        int dp[n];

        for (int i = 0; i < n; i++)
        {
            dp[i] = i;
        }

        for (int i = 1; i < n; i++)
        {
            int j = i;
            int k = i;

            while (j >= 0 && k < n && s[j] == s[k])
            {
                if (j == 0)
                {
                    dp[k] = min(dp[k], 0);
                }
                else
                {
                    dp[k] = min(dp[k], dp[j-1] + 1);
                }

                j--;
                k++;
            }

            j = i-1;
            k = i;

            while (j >= 0 && k < n && s[j] == s[k])
            {
                if (j == 0)
                {
                    dp[k] = min(dp[k], 0);
                }
                else
                {
                    dp[k] = min(dp[k], dp[j-1] + 1);
                }

                j--;
                k++;
            }
        }

        return dp[n-1];
    }
};