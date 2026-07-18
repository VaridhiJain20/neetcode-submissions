class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] state= new int[numCourses];
        Arrays.fill(state,0);
        HashSet<Integer>[] graph= new HashSet[numCourses];
        for(int i=0; i<graph.length; i++){
            graph[i]= new HashSet<>();
        }
        for(int[]p: prerequisites){
      
            graph[p[1]].add(p[0]);            
        }


        for(int i=0; i<state.length; i++){
            if(state[i]==0){
                boolean x= dfs(i, graph, state);
                if(!x){
                    return x;
                }
            }
        }


    return true;
    }

    public boolean dfs(int i,  HashSet<Integer>[] graph, int[]state){
        state[i]=1;

        for(int n: graph[i]){
            if(state[n]==1){
                return false;
            }
            if(state[n]==2){
                continue;
            }
            boolean b= dfs(n, graph, state);
            if(!b){
                return b;
            }
        }

        state[i]=2;
        return true;
    }
}
