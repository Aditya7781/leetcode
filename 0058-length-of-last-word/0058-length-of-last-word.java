class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder result = new StringBuilder();
        s = s.trim();
        int i = s.length()-1;

       while(i < s.length() && i >= 0){
       if(s.charAt(i) == ' ')break;
       result.append(s.charAt(i));
       i--;
    }
    return result.toString().length();
    }
}