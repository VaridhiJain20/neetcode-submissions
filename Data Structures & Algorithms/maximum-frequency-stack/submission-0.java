class FreqStack {
    HashMap<Integer, Integer> freq;
    TreeMap<Integer, Stack<Integer>> st;

    public FreqStack() {
        freq= new HashMap<>();
        st= new TreeMap<>();
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val,0)+1);

        int f= freq.get(val);
        st.putIfAbsent(f, new Stack<>());
        st.get(f).push(val);

        

    }
    
    public int pop() {
     
        int f= st.lastKey();
        int rv= st.get(f).pop();

        if(st.get(f).size()==0){
            st.remove(f);
        }

        if(f==1){
        freq.remove(rv);
        }
        else{
            freq.put(rv, f-1);
        }
        

        return rv;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */