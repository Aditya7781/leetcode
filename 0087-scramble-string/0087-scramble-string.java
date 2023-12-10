class Solution {
    static HashMap<String, Boolean> ump = new HashMap<>();
    static boolean isScramble(String X,String Y)
    {
        String key = X + " " + Y;
        if (ump.containsKey(key))
            return ump.get(key);

        if (X.equals(Y)) {
            ump.put(key, true);
            return true;
        }
        if (X.length() != Y.length()) { // Check if lengths are not equal
            ump.put(key, false);
            return false;
        }

        int n = X.length();
        boolean flag = false;
        for (int i = 1; i <= n - 1; i++) {
            if ((isScramble(X.substring(0, i), Y.substring(n - i, n)) && isScramble(X.substring(i, n), Y.substring(0, n - i))) ||
                (isScramble(X.substring(0, i), Y.substring(0, i)) && isScramble(X.substring(i, n), Y.substring(i, n)))) {
                flag = true;
                break;
            }
        }

        ump.put(key, flag);
        return flag;
    }
}