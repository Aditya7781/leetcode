class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                if(i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                    i++;
                }
            } else {
                i++;
            }
        }
        return n <= 0;
    }
}