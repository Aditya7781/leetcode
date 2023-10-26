class Solution {
    /*
    -> Start from node and check if how may trees are possible, by following the given conditions
    -> dp works as visited array, if we already counter trees from a perticular root do not calculate it again
    */
    private int MOD = (int)(1e9+7);
    public int numFactoredBinaryTrees(int[] arr) {
        long res = 0;
        Set<Integer> nodes = new HashSet(); 
        Map<Integer, Long> dp = new HashMap<>();
        for(int n: arr) nodes.add(n);
        for(int n: arr) solve(n, nodes, dp);
        // Finally add all the trees possible from each value as node
        for(Map.Entry<Integer, Long> e: dp.entrySet()){
            res = (res + e.getValue()%MOD) % MOD;
        }
        return (int)(res%MOD);
    }
    private long solve(int root, Set<Integer> nodes, Map<Integer, Long> dp){
        if(dp.containsKey(root)) return dp.get(root);
        long res = 1;
        Set<Integer> usedNodes = new HashSet<>();
        for(int n: nodes){
            if(n * (root/n) != root) continue;
            if(!usedNodes.contains(n) && nodes.contains(n) && nodes.contains(root/n)){
                long cur = solve(n, nodes, dp) * solve(root/n, nodes, dp);
                // if left and right child of tree are not same, the two trees are possible
                if(n != root/n) res+=cur*2;
                else res+=cur;
                usedNodes.add(n);
                usedNodes.add(root/n);
                res %= MOD;
            }
        }
        dp.put(root, res);
        return res;
    } 
}