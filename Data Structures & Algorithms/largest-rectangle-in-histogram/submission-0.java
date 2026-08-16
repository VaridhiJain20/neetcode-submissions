class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st= new Stack<>();
        int ans= 0;

        for(int i=0; i<heights.length; i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int idx= st.pop();

                int l=-1;
                if(!st.isEmpty()){
                    l= st.peek();
                }

                ans= Math.max(ans, (i-l-1)*heights[idx]);
            }

            st.push(i);
        }

        while(!st.isEmpty() ){
                int idx= st.pop();

                int l=-1;
                if(!st.isEmpty()){
                    l= st.peek();
                }

                ans= Math.max(ans, (heights.length-l-1)*heights[idx]);
            }
        return ans;
    }
}
