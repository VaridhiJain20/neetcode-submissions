class Solution {
    public int uniquePaths(int m, int n) {
        
	    
	    int[][] dp=new int[m][n];
	    
	 
	   int ans= rec(m, n, 0, 0, dp);
	    
	    return ans;
	}

	private int rec(int m, int n, int i, int j, int[][]dp) {
		// TODO Auto-generated method stub
		if(i== m-1 && j==n-1) {
		
			return 1;
		} 
		if(i>m-1 || j> n-1) {
			return 0;
		}
		
		
		if(dp[i][j]!=0) {
		return dp[i][j];
		}
		
		int r= rec(m, n, i, j+1, dp);
		int d= rec(m, n, i+1,j, dp);
		
		return dp[i][j]= r+d;
    }
}