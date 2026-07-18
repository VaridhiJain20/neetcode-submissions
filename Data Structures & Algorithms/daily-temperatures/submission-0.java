class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st= new Stack<>();
        int[] ans=new int[temperatures.length];


        for(int i=0; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                ans[st.peek()]= i- st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            ans[st.pop()]=0;
        }

        return ans;
    }
}
