class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp= new int[n+1][n+1];

        int[]suffix= new int[n];
        suffix[n-1]= piles[n-1];

        for(int i=n-2; i>=0; i--){
            suffix[i]=piles[i]+suffix[i+1];
        }

        for(int i=n-1; i>=0; i--){
            for(int M=1; M<=n; M++){
                int min=Integer.MAX_VALUE;
                for(int x=1; x<=2*M && i+x<=n; x++){
                    int newm= Math.max(M, x);
                    min= Math.min(min, dp[i+x][newm]);
                }
                dp[i][M]= suffix[i]-min;

            }
        }
return dp[0][1];
    }
}