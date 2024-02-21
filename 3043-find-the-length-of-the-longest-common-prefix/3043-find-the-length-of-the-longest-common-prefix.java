class Solution {
    class TrieNode{
        TrieNode[] childrens;
        boolean end;
        
        TrieNode(){
            this.childrens=new TrieNode[10];
            end=false;
        }
    }
    
    TrieNode root;
    
    void insert(String str){
        TrieNode curr=root;
        for(int i=0;i<str.length();i++){
            int index=str.charAt(i)-'0';
            if(curr.childrens[index]==null){
                TrieNode node=new TrieNode();
                curr.childrens[index]=node;
                curr=curr.childrens[index];
            }
            else curr=curr.childrens[index];
        }
        curr.end=true;
    }
    
    int search(String str){
        TrieNode curr=root;
        int lcp=0;
        for(int i=0;i<str.length();i++){
            int index=str.charAt(i)-'0';
            if(curr.childrens[index]==null) break;
            else{
                lcp++;
                curr=curr.childrens[index];
            }
        }
        return lcp;
    }
    
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        if(arr2.length<arr1.length) return longestCommonPrefix(arr2,arr1);
        root=new TrieNode();
        for(int i=0;i<arr1.length;i++){
            insert(String.valueOf(arr1[i]));
        }
        int ans=0;
        for(int i=0;i<arr2.length;i++){
            ans=Math.max(ans,search(String.valueOf(arr2[i])));
        }
        return ans;
    }
}