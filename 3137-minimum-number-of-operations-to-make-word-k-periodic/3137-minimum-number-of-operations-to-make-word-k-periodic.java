class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i = i + k) {
            String periodicWord = word.substring(i, i + k);
            map.put(periodicWord, map.getOrDefault(periodicWord, 0) + 1);
        }
        String mostCommonPeriodicWord = "";
        int highestCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String periodicWord = entry.getKey();
            int count = entry.getValue();
            if (count > highestCount) {
                mostCommonPeriodicWord = periodicWord;
                highestCount = count;
            }
        }
        return (word.length() - mostCommonPeriodicWord.length() * highestCount) / k;
    }
}