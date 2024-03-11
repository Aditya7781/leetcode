class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> orderIndex = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderIndex.put(order.charAt(i), i);
        }

        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        Arrays.sort(charArray, (c1, c2) -> Integer.compare(orderIndex.getOrDefault(c1, 26), orderIndex.getOrDefault(c2, 26)));

        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            result.append(c);
        }

        return result.toString();
    }
}
