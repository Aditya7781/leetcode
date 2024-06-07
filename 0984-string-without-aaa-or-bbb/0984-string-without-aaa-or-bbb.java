class Solution {
    public String strWithout3a3b(int a, int b) {
       StringBuilder sb = new StringBuilder();
       while(a > 0 || b > 0) {
           if (a>b && b != 0) {
               sb.append("aab");
               a-=2;
               b--;
           } else if (b > a && a != 0) {
               sb.append("bba");
               b-=2;
               a--;
           } else {
               if (a > 0) {
                   sb.append("a");
                   a--;
               } else if(b > 0) {
                   sb.append("b");
                   b--;
               }
           }
       }
       return sb.toString();
    }
}