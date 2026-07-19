class Solution {
    public double myPow(double x, int n) {
         double ans= rec(x, Math.abs(n));
		 
		 if(n<0) {
			 return 1/ans;
		 }
		 
		 return ans;
	    }

	private double rec(double x, int n) {
		// TODO Auto-generated method stub
		
		if(n==0) {
			return 1;
		}
		
		double a= rec(x, n/2);
		
		if(n%2==0) {
			return a*a;
		}
		
		return a*a*x;
		
    }
}