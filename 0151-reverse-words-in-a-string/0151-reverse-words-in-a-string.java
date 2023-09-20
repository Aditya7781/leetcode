class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        int n = arr.length;
        StringBuilder reversed = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            reversed.append(arr[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}
