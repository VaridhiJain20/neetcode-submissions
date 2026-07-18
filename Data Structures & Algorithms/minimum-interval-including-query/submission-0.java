class Solution {
    public class i{
        int et;
        int s;
        public i(int et, int s){
            this.et= et;
            this.s= s;
        }
    }


    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                return o1[0]-o2[0];
            }
        });

        int[][]q= new int[queries.length][2];
        for(int i=0; i<q.length; i++){
            q[i][0]=queries[i];
            q[i][1]=i;
        }

        Arrays.sort(q, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<i> pq= new PriorityQueue<>(new Comparator<i>(){
            @Override
            public int compare(i o1, i o2){
                return o1.s-o2.s;
            }
        });

        int idx=0;

        int[]ans= new int[q.length];

        for(int i= 0; i<q.length; i++){
            while(idx<intervals.length && intervals[idx][0]<= q[i][0]){
                pq.offer(new i(intervals[idx][1], intervals[idx][1]-intervals[idx][0]+1));
                idx++;
            }

            while(!pq.isEmpty() && pq.peek().et<q[i][0]){
                pq.poll();
            }
            int a=-1;
            if(!pq.isEmpty()){
                a= pq.peek().s;
            }

            ans[q[i][1]]=a;
        }

        return ans;
    }
}
