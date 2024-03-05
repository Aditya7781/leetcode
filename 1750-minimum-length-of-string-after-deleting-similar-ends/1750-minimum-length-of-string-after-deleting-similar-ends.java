class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar != rightChar) {
                break; 
            }
            while (left < right && s.charAt(left) == leftChar) {
                left++;
            }
            while (left <= right && s.charAt(right) == rightChar) {
                right--;
            }
        }

        return Math.max(0, right - left + 1);
    }
}
