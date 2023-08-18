class Solution {
    int i=0;
    public int scoreOfParentheses(String s) {
         int score = 0;
          while(i<s.length()){
              char f = s.charAt(i);
              i++;
              if(f=='('){
                  if(s.charAt(i)==')'){
                      score = score+1;
                      i++;
                  } else {
                      score  = score+2*(scoreOfParentheses(s));
                  }
              } else {
                  return score;
              }
          }
        return score;
    }
}