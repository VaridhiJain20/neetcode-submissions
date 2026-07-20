class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map= new TreeMap<>();

        int[] ans= new int[nums.length-k+1];
        
        int i;
        for(i=0; i<k; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
        }
        ans[0]=map.lastKey();

        for(int j=1; j<ans.length; j++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
            map.put(nums[i-k],map.get(nums[i-k])-1 );
            if(map.get(nums[i-k])<=0){
                map.remove(nums[i-k]);
            }
            ans[j]=map.lastKey();
            i++;
        }

        return ans;
    }
}
