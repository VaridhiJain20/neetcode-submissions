class Solution {
    int ans;
    public int maxAreaOfIsland(int[][] grid) {
        ans=Integer.MIN_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    rec(i, j, grid, 0);
                }
            }
        }

        return ans;
    }
    public void rec(int i, int j, int[][] grid, int a){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length){
           ans= Math.max(ans, a);
            return;
        }

        if(grid[i][j]!=1){
            ans= Math.max(ans, a);
            return;
        }

        grid[i][j]=0;
        rec(i+1, j, grid, a+1);
        rec(i-1, j, grid, a+1);
        rec(i, j+1, grid, a+1);
        rec(i, j-1, grid, a+1);
    }
}
