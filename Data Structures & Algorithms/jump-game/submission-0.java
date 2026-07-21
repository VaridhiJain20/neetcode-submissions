class Solution {
    public boolean canJump(int[] nums) {
        int far=0;
        for(int i=0; i<nums.length; i++){
            if(far>=i){
                far= Math.max(far, i+nums[i]);
            }
            else{
                return false;
            }


        }

        return true;
    }
}
