class Solution {
    public String mergeAlternately(String word1, String word2) {
     char [] arr1=word1.toCharArray();
     char [] arr2=word2.toCharArray();
     char [] merge = new char[arr1.length+arr2.length];
    int i=0,j=0;
    while( i< merge.length){
        if(j<arr1.length){
            merge[i]=arr1[j];
            i++;
        }
        if( j< arr2.length){
            merge[i]=arr2[j];
            i++;
        }
        j++;
    }
    return new String(merge);
    }
}