class Solution {
   
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    ans= Math.max(ans,rec(i, j, grid));
                }
            }
        }

        return ans;
    }
    public int rec(int i, int j, int[][] grid){
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length){
        
            return 0;
        }

        if(grid[i][j]!=1){
           
            return 0;
        }

        grid[i][j]=0;
        int d= rec(i+1, j, grid);
        int u= rec(i-1, j, grid);
        int r= rec(i, j+1, grid);
        int l= rec(i, j-1, grid);

        return u+d+r+l+1;
    }
}
