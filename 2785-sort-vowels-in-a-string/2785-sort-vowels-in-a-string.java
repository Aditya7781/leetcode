class Solution 
{
    
    public static boolean cheak(char s)
    {
        
        return (s== 'A' ||s== 'E' ||s== 'I'||s== 'O' ||s== 'U' ||s== 'a' || s== 'e' || s== 'i' ||s== 'o' || s== 'u');
      
    }
    
    
    public String sortVowels(String s) 
    {
        ArrayList<Character> vowel = new ArrayList<>();     
        
        for(char i : s.toCharArray() )
        {
            if(cheak(i))
            {
                vowel.add(i);
            }

        }            
         Collections.sort(vowel);
        
         // System.out.println(vowel);
        
        
      String p="";
        int index=0;
        
         for(int i=0 ; i<s.length() ; i++ )
        {
            if(cheak(s.charAt(i))) p += vowel.get(index++);
            else p+=(s.charAt(i));
        }
        
  
            return p;
    }
}