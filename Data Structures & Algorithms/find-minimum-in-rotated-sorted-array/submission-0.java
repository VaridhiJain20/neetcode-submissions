class Solution {
    public int findMin(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int ans=0;

        while(l<=r){
            int mid= l+(r-l)/2;

            if(nums[l]<= nums[mid]){
                if(nums[l]>=nums[r])
                {
                        l= mid+1;

                        ans= nums[r];
                    }
                    else{
                        ans= nums[l];
                        r= mid-1;
                    }
            }
                else{
                  r= mid;
                  ans= nums[mid];  
                }
            }
                return ans;


}}