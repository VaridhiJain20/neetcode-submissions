class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int dr[]= {-1,1,0,0};
        int dc[]= {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr= q.poll();

            int cr= curr[0];
            int cc= curr[1];

            for(int i=0;i<4; i++){
                int nr= cr+dr[i];
                int nc= cc+dc[i];

                if(nr<0 || nr>=grid.length || nc<0 || nc>=grid[0].length){
                    continue;
                }
                if(grid[nr][nc]==2147483647){
                    grid[nr][nc]= grid[cr][cc]+1;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
