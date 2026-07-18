class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp= new int[amount+1][coins.length];
        for(int[]i: dp){
            for(int j=0; j<i.length; j++){
                i[j]=-1;
            }
        }

        return rec(amount, coins,0, dp);
    }

    public int rec(int amt, int[]c, int ldi, int[][] dp){
        if(amt==0){
            return 1;
        }

        if(amt<0){
            return 0;
        }
        if(dp[amt][ldi]!=-1){
            return dp[amt][ldi];
        }

        int cnt=0;
        for(int i=ldi; i<c.length; i++){
            cnt+= rec(amt-c[i], c, i, dp);
        }
return dp[amt][ldi]=cnt;

    }
}
