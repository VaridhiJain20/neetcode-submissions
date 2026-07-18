class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length][2];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        return rec(0, prices, false,dp);

    }

    public int rec(int i, int[] prices, boolean hasC, int[][] dp){
        if(i>=prices.length){
            return 0;
        }
        if(hasC==false && dp[i][0]!=-1){
            return dp[i][0];
        }

        if(hasC==true && dp[i][1]!=-1){
            return dp[i][1];
        }

        int p=0;
        int skip= rec(i+1, prices, hasC, dp);
        if(hasC){
            int sell= prices[i]+rec(i+2, prices, false, dp);
            return dp[i][1]=Math.max(skip, sell);
        }
        else{
            int buy= rec(i+1, prices, true, dp)- prices[i];
            return dp[i][0]=Math.max(skip, buy);
        }
    }
}
