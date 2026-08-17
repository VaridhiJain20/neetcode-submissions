class Solution {
    public int[] sortArray(int[] nums) {
        quick_sort(nums, 0, nums.length-1);
        return nums;
    }

    public void quick_sort(int[] nums, int si, int ei){
        if(si>=ei){
            return;
        }
        int n= nums[ei];

        int i=si;

        for(int j=si; j<ei; j++){
            if(nums[j]<n){
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, ei);

        quick_sort(nums, si, i-1);
        quick_sort(nums, i+1, ei);
    }

    public void swap(int []nums, int i, int j){
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
}