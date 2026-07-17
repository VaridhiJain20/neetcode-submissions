class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> l= new Stack<>();
        Stack<Integer> st= new Stack<>();
        int i=0;
        for(char c: s.toCharArray()){

            if(c=='('){
                l.push(i);
            }
            else if(c=='*'){
                st.push(i);
            }
            else{
                if(!l.isEmpty()){
                    l.pop();
                }
                else if(!st.isEmpty()){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            i++;
        }

       
        
        while(!st.isEmpty() && !l.isEmpty()){
            int si= st.peek();
            int li= l.peek();

            if(si<li){
                return false;
            }
            else{
                st.pop();
                l.pop();
            }
        }
        if(!l.isEmpty()){
            return false;
        }

        return true;
    }
}
