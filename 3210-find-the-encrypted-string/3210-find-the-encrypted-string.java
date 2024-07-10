class Solution {
    public String getEncryptedString(String s, int k) {
        
        
        
  
        
        
        int n = s.length();
        
        k = k % n;
        s= s +s;
        
        return s.substring(k , k+n);
    }
}