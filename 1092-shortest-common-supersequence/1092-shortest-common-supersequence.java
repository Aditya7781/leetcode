class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] t = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        int i = n;
        int j = m;
        StringBuilder s = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                s.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (t[i - 1][j] < t[i][j - 1]) {
                    s.append(str2.charAt(j - 1));
                    j--;
                } else {
                    s.append(str1.charAt(i - 1));
                    i--;
                }
            }
        }

        while (i > 0) {
            s.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            s.append(str2.charAt(j - 1));
            j--;
        }

        return s.reverse().toString();
    }
}
