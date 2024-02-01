class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,mx=0;
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        int n=s.length();
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }
            if(map.size()==j-i+1){
                mx=Math.max(mx,j-i+1);
                j++;
            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    char ch1=s.charAt(i);
                    map.put(ch1,map.get(ch1)-1);
                    if(map.get(ch1)==0){
                        map.remove(ch1);
                    }
                    i++;
                }
                j++;
            }
        }
        return mx;
        
    }
}