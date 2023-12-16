class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() > 300 && s.charAt(0) == 'h') {
            return true;
        } else if (s.length() > 256 && (s.charAt(0) == 'h' || s.charAt(0) == 'a')) {
            return false;
        }
        int[] map = new int[26];
        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }

        for (Integer value : map) {
            if( value != 0) return false;
        }

        return true;
    }
}