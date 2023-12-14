class MinStack {
    
    Stack<Integer> stk;
    Stack<Integer> supportingstk;
    public MinStack() {
        stk = new Stack<>();
        supportingstk = new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(supportingstk.size()==0 || supportingstk.peek()>=val){
            supportingstk.push(val);
        }
    }
    
    public void pop() {
        int ans=stk.peek();
        stk.pop();
        if(supportingstk.peek()==ans){
            supportingstk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return supportingstk.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */