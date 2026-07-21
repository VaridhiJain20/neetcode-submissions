class Solution {
    public int evalRPN(String[] tokens) {
         Stack<Integer> st= new Stack<>();
		 
		 for (int i = 0; i < tokens.length; i++) {
			if(!isOperator(tokens[i])) {
				st.push(Integer.parseInt(tokens[i]));
			}
			
			else {
				int a= st.pop();
				int b= st.pop();
				
				int res= apply(b, a, tokens[i]);
				
				st.push(res);
			}
		}
		 
		 
		 
		return st.pop();
	        
	    }

	private int apply(int b, int a, String string) {
		// TODO Auto-generated method stub
		
		if(string.equals("+")) {
			return b+a;
		}
		if(string.equals("-")) {
			return b-a;
		}
		if(string.equals("/")) {
			return b/a;
		}
		if(string.equals("*")) {
			return b*a;
		}
		
		return 0;
	}

	private boolean isOperator(String string) {
		// TODO Auto-generated method stub
		
		if( string.equals("+") || string.equals("-") || string.equals("/") || string.equals("*") ) {
			return true;
		}
		return false;
    }
}