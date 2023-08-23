class Solution {
    //approach: store the character and frequency in a map
    //store character into a maxheap
    //poll the elements and store them at even indices and then at odd indices
    //if any character  matches to its last character return false;
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        char arr[]=new char[s.length()];
        int n=arr.length;
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:map.keySet())
            pq.add(c);
        int curr=0;
        while(pq.size()>0){
            char c=pq.poll();
            int freq=map.get(c);
            while(freq>0){
                arr[curr]=c;
                curr+=2;
                freq--;
                if(curr>=n)
                    curr=1;
            }
        }
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1])
                return "";
        }
        String res=new String(arr);
        return res;
    }
}