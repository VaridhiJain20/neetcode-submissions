class Solution {
    public int minSubArrayLen(int target, int[] nums) {
             
		 int i=0;
		 int j=0;
		 
		 int sum=0;
		 int ans=Integer.MAX_VALUE;
		 
		 while(i<nums.length && j< nums.length) {
			 sum+= nums[j];
			 
			 
			while(sum>= target) {
				 ans= Math.min(j-i+1, ans);
				 sum-= nums[i];
				 i++;
			 }
			 
			j++;
			
		 }
		 
		 
		 while(sum>= target) {
			 ans= Math.min(j-i+1, ans);
			 
			 sum-= nums[i];
			 i++;
		 }

          if(ans== Integer.MAX_VALUE) {
			 return 0;
		 }
		 
		 return ans;
		 
    }
}