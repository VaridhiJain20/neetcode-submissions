class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map= new HashMap<>();

        for(int n:nums){
            if(map.containsKey(n-1)){
                map.put(n, false);
            }
            else{
                map.put(n, true);
              
            }
            if(map.containsKey(n+1)){
                map.put(n+1, false);
            }
        }
        int ans=0;

        for(int k: map.keySet()){
            if(!map.get(k)){
                continue;
            }
            int i=k;
            int cnt=0;
            while(map.containsKey(i++)){
                cnt++;
            }
            ans= Math.max(ans, cnt);
        }
        return ans;
    }
}
