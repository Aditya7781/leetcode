class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int mx = Integer.MIN_VALUE;
        while (j < s.length()) {
            char currentChar = s.charAt(j);
            mp.put(currentChar, mp.getOrDefault(currentChar, 0) + 1);
            
            if (mp.size() > j-i+1) {
                j++;
            } else if (mp.size() == j-i+1) {
                mx = Math.max(mx, j - i + 1);
                j++;
            } else if (mp.size() < j-i+1) {
                while (mp.size() < j-i+1) {
                    char rem = s.charAt(i);
                    mp.put(rem, mp.get(rem) - 1);
                    if (mp.get(rem) == 0) {
                        mp.remove(rem);
                    }
                    i++;
                }
                j++;
            }
        }
        return (mx == Integer.MIN_VALUE) ? -1 : mx;
    }
}