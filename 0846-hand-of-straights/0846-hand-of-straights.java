class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize!= 0) {
            return false;
        }
        
        Arrays.sort(hand);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : hand) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        for (int num : hand) {
            if (countMap.get(num) == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int target = num + i;
                if (!countMap.containsKey(target) || countMap.get(target) == 0) {
                    return false;
                }
                countMap.put(target, countMap.get(target) - 1);
            }
        }
        
        return true;
    }
}