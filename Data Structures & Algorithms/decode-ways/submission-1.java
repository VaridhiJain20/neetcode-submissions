class Solution {
    public int numDecodings(String s) {
        int[] dp= new int[s.length()];
        Arrays.fill(dp,-1);
        return rec(s, 0, dp);
    }

    public int rec(String s, int i, int[]dp){
        if(i>s.length()){
            return 0;
        }
        if(i == s.length()){
    return 1;
}
if(dp[i]!=-1){
    return dp[i];
}
 if(s.charAt(i)=='0'){
            return dp[i]=0;
        }
        int o= rec(s, i+1, dp);
       
        int t= 0;
        if(i+1<s.length()){
            int a= Integer.parseInt(""+s.charAt(i)+s.charAt(i+1));
            if( a>0 && a<27){
                t= rec(s, i+2, dp);
            }
        }
        return dp[i]= o+t;
    }
}
