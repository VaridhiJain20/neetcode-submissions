class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int max= piles[0];
		 for (int i = 1; i < piles.length; i++) {
			max= Math.max(max, piles[i]);
		}
		 
		 int lo= 1;
		 int hi= max;
		 
		 int ans=0;
		 
		 
		 while(lo<=hi) {
			 int mid= lo+ (hi-lo)/2;
			 
			 if(isPoss(mid, piles, h)) {
				 ans= mid;
				 hi= mid-1;
			 }
			 else {
				 lo= mid+1;
			 }
		 }
		 
		 return ans;
		 
	    }

	private boolean isPoss(int mid, int[] piles, int h) {
		// TODO Auto-generated method stub
		

		
		int hrs=0;
		
		for (int i = 0; i < piles.length; i++) {
			if(hrs>h) {
				return false;
			}
			
			hrs+= piles[i]/ mid;	
			if(piles[i]% mid== 0) {
			
			}
			
			else {
				hrs+=1;
			}
			
		}
		
		if(hrs>h) {
			return false;
		}
		
		return true;   
    }
}