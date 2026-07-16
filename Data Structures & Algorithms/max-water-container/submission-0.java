class Solution {
    public int maxArea(int[] height) {
           int ans= Integer.MIN_VALUE;
	    int lo=0;
	    int hi= height.length-1;
	    
	 while(lo<hi) {
		 int wall= Math.min(height[lo], height[hi]);
		 ans= Math.max(ans, wall* (hi-lo));
		 
		 if(height[lo]< height[hi]) {
			 lo++;
		 }
		 
		 else {
			 hi--;
		 }
	 }
	 
	 return ans;
    }
}