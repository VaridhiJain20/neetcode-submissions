class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freq= new HashMap<>();
        for(int a: arr){
            freq.put(a, freq.getOrDefault(a, 0)+1);
        }

        int ans =-1;

        for(int n: freq.keySet()){
            if(n==freq.get(n)){
                ans= Math.max(ans, n);
            }
        }

        return ans;
    }
}