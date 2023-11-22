class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        //first lcs nikalo then print lcs and then non lcs elements add kar do
        // str1+str2 - lcs will be answer
        //X+Y-LCS will be the answer
        
        //first finding the LCS

        int m = str1.length();
        int n= str2.length();
        int[][] t = new int[m+1][n+1];
        for(int i=0; i<m+1; i++){
            for(int j=0; j<n+1; j++){
                t[i][0]=0;
                t[0][j]=0;
            }
        }
        
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                   t[i][j] = 1+t[i-1][j-1]; 
                }
                else{
                    t[i][j]= Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        
        int lcs0 = t[m][n];
        int i=m, j=n;
        StringBuilder sb = new StringBuilder();
        while(j>0 && i>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(t[i-1][j]>t[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        sb.reverse();
        String lcs = sb.toString();
        String ans="";

        //LCS found, now str1+str2-LCS is the answer
//that is we have to concate str1 and str2, but LCS is present in both of them so we have to add the LCS elements only once

        int k=0, l=0;

        for(char ch : lcs.toCharArray() ){
            while(k<str1.length() && str1.charAt(k)!=ch){
                ans+=str1.charAt(k++);
            }
            while(l<str2.length() && str2.charAt(l)!=ch){
                ans+=str2.charAt(l++);
            }
            ans+=ch;
            k++;
            l++;
        }

        //adding remaining chars from st1 or str2
        ans+=str1.substring(k);
        ans+=str2.substring(l);
        
        return ans;
    }
}