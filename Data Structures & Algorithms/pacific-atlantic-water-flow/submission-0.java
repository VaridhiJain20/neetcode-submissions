class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        HashSet<List<Integer>> visitedP= new HashSet<>();
        HashSet<List<Integer>> visitedA= new HashSet<>();   

        for(int i=0; i<heights[0].length; i++){
            dfs(0,i, heights, visitedP);
        }

        for(int i=1; i<heights.length; i++){
            dfs(i,0, heights, visitedP);
        }

        for(int i=0; i<heights[0].length; i++){
            dfs(heights.length-1, i, heights, visitedA);
        }

        for(int i=0; i<heights.length-1; i++){
            dfs(i,heights[0].length-1, heights, visitedA);
        }

        List<List<Integer>> ans= new ArrayList<>();
        for(List<Integer> c: visitedP){
            if(visitedA.contains(c)){
                ans.add(c);
            }
        }

        return ans;
    }

    int[] dr= {-1,1,0,0};
    int[] dc= {0,0,-1,1};

    public void dfs(int r, int c, int[][]heights, HashSet<List<Integer>> visited){
      
        List<Integer> l=new ArrayList<>(Arrays.asList(r, c));
        if(visited.contains(l)){
            return;
        }

        visited.add(l);

        for(int i=0; i<4; i++){
            int nr= r+dr[i];
            int nc= c+dc[i];

            if(nr<0 || nc<0 || nr>=heights.length || nc>= heights[0].length){
                continue;
            }

            if(heights[nr][nc]>= heights[r][c]){
                dfs(nr, nc, heights, visited);
            }
        }
    
    }
}
