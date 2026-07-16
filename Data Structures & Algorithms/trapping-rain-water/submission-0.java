class Solution {
    public int trap(int[] height) {
          int total= 0;
    int[] left= new int[height.length];
    int[] right= new int[ height.length];
    
    
    left[0]= height[0];
    right[height.length-1]= height[height.length-1];
    
    for (int i=1; i<left.length; i++) {
    	left[i]= Math.max(left[i-1], height[i]);
    }
    
    for (int i=right.length-2; i>=0; i--) {
    	right[i]= Math.max(right[i+1], height[i]);
    }
    
    for(int i=0; i<height.length; i++) {
    	int min= Math.min(left[i], right[i]);
    	total+= min-height[i];
    	
    }
	
	return total;
    }
}