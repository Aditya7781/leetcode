class Solution {
    public int minimumCardPickup(int[] cards) {
        int minimumCardPickup = Integer.MAX_VALUE;
        boolean[] seen = new boolean[1000001];

        int leftIndex = 0;

        for (int rightIndex = 0; rightIndex < cards.length; rightIndex++) {
            if (seen[cards[rightIndex]]) {
                while (cards[leftIndex] != cards[rightIndex]) {
                    seen[cards[leftIndex]] = false;
                    leftIndex++;
                }

                minimumCardPickup = Math.min(minimumCardPickup, rightIndex - leftIndex + 1);
                leftIndex++;

            } else {
                seen[cards[rightIndex]] = true;
            }
        }

        return minimumCardPickup == Integer.MAX_VALUE ? -1 : minimumCardPickup;
    }
}