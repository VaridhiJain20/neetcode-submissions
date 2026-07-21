class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> ans= new ArrayList<>();
		 
		 List<Integer> list= new ArrayList<>();
		 rec(nums, 0, list, ans );
		 
		 return ans;
				 
		 
	    }

	private void rec(int[] nums, int i, List<Integer> list, List<List<Integer>> ans) {
		// TODO Auto-generated method stub
		if(i== nums.length) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		 List<Integer> nl= new ArrayList<>(list);
		 nl.add(nums[i]);
		rec(nums, i+1, list, ans);
		rec(nums, i+1, nl, ans);
    }
}