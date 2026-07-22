class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums){
            sum+= n;
        }

        if(sum%2==1){
            return false;
        }
        int target= sum/2;
        Boolean[][]dp= new Boolean[nums.length][target+1];
        
       return rec(0,nums, 0, target, dp);
    }

    public boolean rec(int idx, int[] nums, int s, int t, Boolean[][] dp){
       
        if(s==t){
            return true;
        }
        if(s>t){
            return false;
        }
         if(idx>=nums.length){

            return false;
        }
        if(dp[idx][s]!=null){
            return dp[idx][s];
        }

        return dp[idx][s]= rec(idx+1, nums, s+nums[idx], t, dp) || rec(idx+1, nums, s, t, dp);

    }
}
