class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new LinkedList<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i, j,0});
                }
            }
        }

        int ans= -1;
        int[] rd= {-1,1,0,0};
        int[] cd= {0,0,-1,1};

        while(!q.isEmpty()){
            int[] curr= q.poll();
            ans= Math.max(ans, curr[2]);

            for(int i=0;i<4; i++){
                int nr= curr[0]+rd[i];
                int nc= curr[1]+cd[i];

                if(nr<0 || nr>=grid.length ||nc<0 ||nc>=grid[0].length){
                    continue;
                }
                if(grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr, nc, curr[2]+1});
                }
            }
        }


        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                 return -1;
                }
            }
        }

        return ans;
    }
}
