class Solution {
     public class pair{
        String n;
        int d;
        public pair(String n, int d){
            this.n= n;
            this.d= d;
        }
    }


    public int minCostConnectPoints(int[][] points) {
        //  HashMap<Integer, Integer>[] graph= new HashMap[n+1];
        // for(int i=1; i<n+1; i++){
        //     graph[i]= new HashMap<>();
        // }

        // for(int []e: times){
        //     graph[e[0]].put(e[1], e[2]);
        // }


        PriorityQueue<pair> pq= new PriorityQueue<>(new Comparator<pair>(){
            @Override
            public int compare(pair o1, pair o2){
                return o1.d- o2.d;
            }
        });

        HashSet<String> set= new HashSet<>();
        int cost= 0;

        for(int[]pt: points){
            String s=""+pt[0]+','+pt[1];

            if(set.contains(s))continue;

            pq.offer(new pair(s,0));


               while(!pq.isEmpty()){
            pair p= pq.poll();
            if(set.contains(p.n)){
                continue;
            }
            set.add(p.n);
            cost+= p.d;

            for(int []x: points){
                 String s1=""+x[0]+','+x[1];

            if(set.contains(s1))continue;

            String[] arr = p.n.split(",");

            int d= Math.abs(x[0]- Integer.parseInt(arr[0]))+Math.abs(x[1]- Integer.parseInt(arr[1]));
                pq.offer(new pair(s1, d));
            }

        }

        }

     
       
        return cost;
    }






    
}
