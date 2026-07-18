class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         HashSet<Integer>[] graph= new HashSet[numCourses];
		 
		 for (int i = 0; i < graph.length; i++) {
			graph[i]= new HashSet<>();
		}
		 
        int[] indeg= new int[numCourses];
		 for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
		}


        Queue<Integer> q= new LinkedList<>();

        for(int i=0; i<indeg.length; i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }

        int[] ans= new int[numCourses];
        int i=0;

        while(!q.isEmpty()){
            int curr= q.poll();
            ans[i++]=curr;


            for(int nbr: graph[curr]){
                indeg[nbr]--;
                if(indeg[nbr]==0){
                    q.offer(nbr);
                }
            }
        }

        if(i!=numCourses){
            return new int[]{};
        }
return ans;
    }
}
