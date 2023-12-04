public class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        String empty = "";
        int temp = 0;
        boolean check = true;

        for (int i = 0; i < num.length() - 2; i++) {
            if (i + 2 < num.length() && num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                temp = Math.max(temp, num.charAt(i) - '0');
                check = false;
            }
        }

        if (!check) {
            for (int i = 0; i < 3; i++) {
                ans += temp;
            }
        } else {
            return empty;
        }

        return ans;
    } 
}
