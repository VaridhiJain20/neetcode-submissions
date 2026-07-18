class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer,Integer>[] dp= new HashMap[nums.length+1];

        
        for (int i = 0; i <= nums.length; i++) {
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
               dp[i].put(sum,0);
                return 0;
            }
        }
        if (dp[i].containsKey(sum)) {
    return dp[i].get(sum);
}

        int p= dp(nums, target, dp,i+1, sum+nums[i]);
        int n= dp(nums, target, dp, i+1, sum-nums[i]);        

        dp[i].put(sum, p+n);
        return p+n;
    }
}
