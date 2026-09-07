class Solution {
    public int numDistinct(String s, String t) {
        	 int[][] dp= new int[s.length()][t.length()];
		 
		 for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j]=-1;
			}
		}
		 int ans= rec(s, t, 0, 0, dp);
		return ans;
	        
	    }

	private int rec(String s, String t, int i, int j, int[][]dp) {
		// TODO Auto-generated method stub
		if(j== t.length()) {
			return 1;
		}
		
		if(i== s.length()) {
			return 0;
		}
		
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		int count=0;
		if(s.charAt(i)== t.charAt(j)) {
			count+= rec(s, t, i+1, j+1, dp);
		}
		count+= rec(s, t, i+1, j, dp);
		return dp[i][j]=count;
    }
}