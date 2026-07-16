class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        List<Integer>[] graph= new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i]= new ArrayList<>();
        }
        boolean[] visited= new boolean[n];

        for(int[]e: edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(0, graph, visited);

        for(boolean b: visited){
            if(!b){
                return false;
            }
        }

        return true;
    }

    public void dfs(int n,List<Integer>[] graph, boolean[] visited){
        if(visited[n]){
            return;
        }
        visited[n]=true;

        for(int nbr: graph[n]){
            dfs(nbr, graph, visited);
        }
    }
}
