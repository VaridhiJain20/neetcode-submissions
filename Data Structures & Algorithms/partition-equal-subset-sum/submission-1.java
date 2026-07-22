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
        
       return rec(0,nums, 0, target);
    }

    public boolean rec(int idx, int[] nums, int s, int t){
       
        if(s==t){
            return true;
        }
         if(idx>=nums.length){

            return false;
        }

        return rec(idx+1, nums, s+nums[idx], t) || rec(idx+1, nums, s, t);

    }
}
