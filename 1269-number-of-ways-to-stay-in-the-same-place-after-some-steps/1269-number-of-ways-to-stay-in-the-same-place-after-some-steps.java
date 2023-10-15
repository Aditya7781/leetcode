class Solution {
    static int max_len,MOD=1000000007;
    public static long calc(int idx,int steps,HashMap<String,Long> map){
       String str=idx+" --> "+steps;
       if(idx==0 && steps==0) return 1;
       if(idx==max_len || idx<0 || steps<=0) return 0;
       if(map.containsKey(str)) return map.get(str);
       long c1=calc(idx+1,steps-1,map)%MOD;
       long c2=calc(idx-1,steps-1,map)%MOD;
       long c3=calc(idx,steps-1,map)%MOD;
       long val=(c1+c2+c3)%MOD;
       map.put(str,val);
       return map.get(str);
    }
    
    public int numWays(int steps, int arrLen) {
        HashMap<String,Long> map = new HashMap<>();
        max_len=arrLen; 
        return (int)calc(0,steps,map)%MOD;
    }
}