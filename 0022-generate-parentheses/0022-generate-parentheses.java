class Solution {
    public List<String> generateParenthesis(int n) {
        int open =n;
        int close =n;
        List<String> ans = new ArrayList<>();
        String op = "";
        helper(open, close, op, ans);
        return ans;
    }
    public void helper(int open, int close, String op, List<String> ans){
        if(open==0 && close==0){
            ans.add(op);
            return;
        }
        if(close>open){
            //i.e both choices is there            
            String op1=op;
            String op2=op;
            if(open>0){
                op1+="(";
                helper(open-1, close, op1, ans);
            }            
            op2+=")";
            helper(open, close-1, op2, ans);
        }
        else{
            //can only choose open bracket
            op+="(";
            helper(open-1, close, op, ans);
        }
    }
}