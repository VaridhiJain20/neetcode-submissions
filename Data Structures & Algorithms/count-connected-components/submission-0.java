class Solution {
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer>[] graph= new HashSet[n];
        for(int i=0; i<n; i++){
            graph[i]= new HashSet<>();
        }

        for(int[]e: edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

     return dft(graph);   
    }

    public int dft(HashSet<Integer>[] graph){
        HashSet<Integer> vis= new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        int cnt=0;

        for(int i=0; i<graph.length; i++){
            if(!vis.contains(i)){
                cnt++;
                
                q.offer(i);

                while(!q.isEmpty()){
                    int n= q.poll();
                    vis.add(n);

                    for(int nbr: graph[n]){
                        if(!vis.contains(nbr)){
                            q.offer(nbr);
                        }
                    }

                }

            }
        }

        return cnt;
    }
}
