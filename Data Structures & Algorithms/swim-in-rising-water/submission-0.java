class Solution {
    public class pair{
        String n;
        int c;

        public pair(String n, int c){
            this.n= n;
            this.c= c;
        } 
    }

    public int swimInWater(int[][] grid) {
        PriorityQueue<pair> pq= new PriorityQueue<>(new Comparator<pair>(){
            @Override

            public int compare (pair o1, pair o2){
                return o1.c- o2.c;
            }
        });

        HashSet<String> vis= new HashSet<>();

        int n= grid.length-1;

        pq.offer(new pair("0,0", grid[0][0]));

        int[] dr= {1,-1,0,0};
        int[] dc= {0,0,-1,1};

        while(!pq.isEmpty()){
            pair p= pq.poll();
            if(vis.contains(p.n)){
                continue;
            }
            if(p.n.equals(n+","+n)){
                return p.c;
            }

            vis.add(p.n);

            String[] coord= p.n.split(",");
            int r= Integer.parseInt(coord[0]);
            int c= Integer.parseInt(coord[1]);

            for(int i=0; i<4; i++){
                int nr= r+dr[i];
                int nc= c+dc[i];

                if(nr<=n && nr>=0 && nc<=n && nc>=0){
                    pq.offer(new pair(nr+","+nc, Math.max(p.c, grid[nr][nc])));
                }
            }

        }

        return -1;


    }
}
