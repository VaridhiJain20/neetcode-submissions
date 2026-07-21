class MinStack {
    Stack<Integer> st;
    Stack<Integer> curr;

    public MinStack() {
        st= new Stack<>();
        curr= new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        int min= val;
        if(!curr.isEmpty()){
            min= Math.min(curr.peek(), min);
        }

        curr.push(min);
    }
    
    public void pop() {
        st.pop();
        curr.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return curr.peek();
    }
}
