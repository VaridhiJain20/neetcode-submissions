class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,Integer>[] dp= new HashMap[nums.length];

        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
        }

        return dp(nums, target, dp,0,0);
    }

    public int dp(int[] nums, int target, HashMap<Integer,Integer>[] dp, int i, int sum){
       
        if(i==nums.length ){
            if(sum==target){
                dp[i].put(sum,1);
                return 1;
            }
            else{
               
                return 0;
            }
        }

        int p= dp(nums, target, dp,i+1, sum+nums[i]);
        int n= dp(nums, target, dp, i+1, sum-nums[i]);        

        dp[i].put(sum, p+n);
        return p+n;
    }
}
