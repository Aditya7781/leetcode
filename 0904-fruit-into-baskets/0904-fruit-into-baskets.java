class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;
        int mx = Integer.MIN_VALUE;
        while (j < fruits.length) {
            int curr = fruits[j];
            mp.put(curr, mp.getOrDefault(curr, 0) + 1);
            
            if (mp.size() <= 2) {
                mx = Math.max(mx, j - i + 1);
                j++;
            } else if (mp.size() > 2) {
                while (mp.size() > 2) {
                    int rem = fruits[i];
                    mp.put(rem, mp.get(rem) - 1);
                    if (mp.get(rem) == 0) {
                        mp.remove(rem);
                    }
                    i++;
                }
                j++;
            }
        }
        return (mx == Integer.MIN_VALUE) ? -1 : mx;
    }
}
