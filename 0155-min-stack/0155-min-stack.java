class MinStack {
    Stack <Long> st;
    long me;
    public MinStack() {
       st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
        { st.push((long)val);
           me = (long)val;
        }
        else{
            if((long)val >= me)
            st.push((long)val);
            else{
                st.push((long)2*val - me);
                me = (long)val;
            }
        }
    }
    
    public void pop() {
            if(st.isEmpty())
            return;
            else{
            if(st.peek() >= me)
            st.pop();
            else{
                me = 2*me - st.peek();
                st.pop();
            }
        }
    }
    
    public int top() {
        Integer b;
        if(st.isEmpty())
        b = -1;
        else{
            //int b;
            if(st.peek()>=me)
            b = (int)(long)st.peek();
            else
            b= (int)(long)me;
        }
        return b;
    }
    
    public int getMin() {
        int x;
        if(st.isEmpty())
        x= -1;
        else
        x =(int)(long)me;
        return x;
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