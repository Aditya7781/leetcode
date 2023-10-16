public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0;
        
        while (j < n) {
            if (s.charAt(j) == '1') {
                cnt++;
            }
            if (cnt == k) {
                while (i < n && cnt == k) {
                    String s1 = s.substring(i, j + 1);
                    if (ans.isEmpty() || s1.length() < ans.length()) {
                        ans = s1;
                    } else if (ans.length() == s1.length()) {
                        ans = min(ans, s1);
                    }
                    if (s.charAt(i) == '1') {
                        cnt--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
    private String min(String s1, String s2) {
        return s1.compareTo(s2) < 0 ? s1 : s2;
    }
}
