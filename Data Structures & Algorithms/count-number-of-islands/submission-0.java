class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid, i, j);
                }
            }
        }


        return ans;
    }
    int[]dr= {-1,1,0,0};
    int[]dc= {0,0,-1,1};

    public void dfs(char[][] grid, int i, int j){
        

        grid[i][j]='0';

        for(int k=0; k<4; k++){
            int nr= i+dr[k];
            int nc= j+dc[k];

            if(nr>=grid.length || nr<0 || nc>= grid[0].length || nc<0 || grid[nr][nc]=='0'){
                continue;
            }

            dfs(grid, nr, nc);
        }

    }

}
