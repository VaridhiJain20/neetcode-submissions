class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        	 
		 
		 List<List<Integer>> ans= new ArrayList<>();
		 
		 Arrays.sort(nums);
		 
		 for (int i = 0; i < nums.length; i++) {
			if(i>0 && nums[i]== nums[i-1]) {
				continue;
			}
			
			int lo= i+1;
			int hi= nums.length-1;
			
			while(lo< hi) {
					
				
				
				if(nums[lo] + nums[hi]+ nums[i]==0) {
					List<Integer> nl= new ArrayList<>();
					
					nl.add(nums[lo]);
					nl.add(nums[hi]);
					nl.add(nums[i]);
					
					ans.add(nl);
					
					lo++;
					hi--;
					
					
					   while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
			            while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
				}
				
				else if(nums[lo] + nums[hi]+ nums[i]<0) {
					lo++;
				}
				
				else {
					hi--;
				}
			}
			
		}
		 
		return ans;
	        
    }
}