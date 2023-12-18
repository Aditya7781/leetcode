class Solution {
    public int removeAlmostEqualCharacters(String word) {
        // aaaaa
        //  ^ -> aaa
        // aaaaaa
        //  ^ -> 1+ aaaa
        //    ^ -> 2+ aa
        //      ^ 3+0
        // abddez
        //  ^   1+ ddez
        //    ^ 2+ ez
        //      ^        
        // zyxyxyz
        // acdcf
        //  ^
        //   ^ 1+ cf
        //     
        
        return helper(word, 1);
    }
    public int helper(String word, int start) {
        if(start>=word.length()) return 0;
 
        if(Math.abs(word.charAt(start-1) - word.charAt(start))<=1){
            return 1+ helper(word,  start+2);
        }
        return helper(word,  start+1);
    }
}