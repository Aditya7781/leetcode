class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freqS.put(c, freqS.getOrDefault(c, 0) + 1);
        }
        
        for (char i : t.toCharArray()) {
            freqT.put(i, freqT.getOrDefault(i, 0) + 1);
        }
        
        int totalDifferences = 0;
        for (char ch : freqS.keySet()) {
            int countS = freqS.get(ch);
            int countT = freqT.getOrDefault(ch, 0);
            totalDifferences += Math.max(0, countS - countT);
        }

        return totalDifferences;
    }
}
