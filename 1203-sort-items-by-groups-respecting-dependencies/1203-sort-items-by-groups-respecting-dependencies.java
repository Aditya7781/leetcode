class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        map = new HashMap<>();
        ind = new int[n+m];
        this.n = n;

        for(int i = 0; i < n; i++) {
            if(group[i] != -1) {
                map.computeIfAbsent(n+group[i], x -> new ArrayList<>()).add(i);
                ind[i]++;
            }
        }

        for(int i = 0; i < n; i++) {
            int a = group[i] == -1 ? i : (n + group[i]);
            for(int before : beforeItems.get(i)) {
                int b = group[before] == -1 ? before : (n+group[before]);
                if(a == b) {
                    map.computeIfAbsent(before, x -> new ArrayList<>()).add(i);
                    ind[i]++;
                } else {
                    map.computeIfAbsent(b, x -> new ArrayList<>()).add(a);
                    ind[a]++;
                }
            }
        }

        res = new int[n];
        idx = 0;
        for(int i = 0; i < ind.length; i++) {
            if(ind[i] == 0) dfs(i);
        }
        return idx == n ? res : new int[0];
    }

    public void dfs(int i) {
        if(i < n) res[idx++] = i;
        ind[i] = -1;
        if(!map.containsKey(i)) return;
        for(int next : map.get(i)) {
            if(ind[next]-- == 1) dfs(next);
        }
    }


    Map<Integer, List<Integer>> map;
    int[] ind;
    int idx;
    int[] res;
    int n;
}