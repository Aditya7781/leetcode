class Solution {
    public int numDecodings(String s) {
        Integer[] mem = new Integer[s.length() + 1];
        return dfs(s, 0, mem);
    }

    private boolean isValid(int n) {
      return n >= 1 && n <= 26;
    }

    private int dfs(String s, int i, Integer[] mem) {
        if (mem[i] != null) return mem[i];

        if (i >= s.length()) return 1;
        
        int total = 0;
        int n1 = s.charAt(i) - '0';
        int n2 = i + 1 < s.length() ? s.charAt(i+1) - '0' : -1;
        
        if (isValid(n1)) {
            total+= dfs(s, i+1, mem);
        } else return 0;// we have zero return directly 
        if (n2 != -1 && isValid((n1 * 10) + n2)) {
           total+= dfs(s, i+2, mem);
        }
        mem[i] = total;
        return mem[i];
    }
}