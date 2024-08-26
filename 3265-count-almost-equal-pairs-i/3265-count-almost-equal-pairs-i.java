class Solution {
    public int countPairs(int[] nums) {
        int ans = 0;
        for (int i = 0;i<nums.length;i++) {
            for (int j = i+1;j<nums.length;j++){
                if (check(nums[i],nums[j])) {ans++;}
            }
        }
        return ans;
    }
    public boolean check (int num1, int num2) {
        if (num1 == num2) {return true;}
        if (checkSwap(num1+"",num2+"")) {
            return true;
        }
        if (checkSwap(num2+"",num1+"")) {
            return true;
        }
        return false;
    }

    public boolean checkSwap (String s1, String s2) {
        for (int i = 0;i<s1.length();i++) {
            for (int j = i+1;j<s1.length();j++) {
                char[] c = s1.toCharArray();
                swap(c,i,j);
                if (Integer.parseInt(String.valueOf(c)) == Integer.parseInt(s2)) {
                    return true;
                }
                swap(c,i,j);
            }
        }
        return false;
    }
    public void swap (char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}