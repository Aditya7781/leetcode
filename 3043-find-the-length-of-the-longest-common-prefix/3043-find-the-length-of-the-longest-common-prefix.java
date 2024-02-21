class Node{
    char ch;
    boolean terminal;
    HashMap<Character,Node> hp;

    Node(char ch, boolean terminal,HashMap<Character,Node> hp){
        this.ch = ch;
        this.terminal = terminal;
        this.hp = hp;
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node('.',false,new HashMap<>());
    }
    
    public void insert(String s) {
        Node curr = root;
        int n = s.length();
        for(int i=0; i<n; i++){
            HashMap<Character,Node> hp = curr.hp;
            char ch = s.charAt(i);
            if(hp.containsKey(ch)){
                curr = hp.get(ch);
            }else{
                Node x = new Node(ch,(i==n-1)?true:false,new HashMap<>());
                hp.put(ch,x);
                curr = x;
            }
        }
        curr.terminal = true;
    }
    
    public int search(String s) {
        Node curr = root;
        int n = s.length();
        int count = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            HashMap<Character,Node> hp = curr.hp;
            if(hp.containsKey(ch)){
                curr = hp.get(ch);
                count++;
            }else{
                return count;
            }
        }
        return count;
    }
}


class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();
        for(var a : arr1){
            t.insert(String.valueOf(a));
        }

        int ans = 0;

        for(var a : arr2){
            ans = Math.max(ans,t.search(String.valueOf(a)));
        }
        return ans;
    }
}