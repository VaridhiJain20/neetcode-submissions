class Solution {
    public class pair{
        int n;
        int d;
        public pair(int n, int d){
            this.n= n;
            this.d= d;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Integer>[] graph= new HashMap[n+1];
        for(int i=1; i<n+1; i++){
            graph[i]= new HashMap<>();
        }

        for(int []e: times){
            graph[e[0]].put(e[1], e[2]);
        }


        PriorityQueue<pair> pq= new PriorityQueue<>(new Comparator<pair>(){
            @Override
            public int compare(pair o1, pair o2){
                return o1.d- o2.d;
            }
        });

        HashSet<Integer> set= new HashSet<>();
        int ans= -1;

        pq.offer(new pair(k,0));

        while(!pq.isEmpty()){
            pair p= pq.poll();
            if(set.contains(p.n)){
                continue;
            }
            set.add(p.n);
            ans= Math.max(ans, p.d);

            for(int nbr: graph[p.n].keySet()){
                pq.offer(new pair(nbr, p.d+graph[p.n].get(nbr)));
            }

        }
        if(set.size()!=n){
            return -1;
        }
        return ans;
    }
}
