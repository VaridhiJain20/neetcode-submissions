class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp= new int[amount+1];
        dp[0]=0;

        for(int i=1; i<dp.length; i++){
            dp[i]= amount +1;
        }


        for(int i=1; i<dp.length; i++){
            for(int c:coins){
                if((long)i-c<0){
                    continue;
                }
                dp[i]= Math.min(dp[i],dp[i-c]+1);
            }
        }

        if(dp[amount]> amount){
            return -1;
        }
        return dp[amount];
    }
}
