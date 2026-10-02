class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int g: gifts){
            pq.offer(g);
        }

        for(int i=0; i<k; i++){
            int g= pq.poll();
            int a= (int) Math.pow(g,0.5);
            pq.offer(a);
        }
        long ans=0;

        while(!pq.isEmpty()){
            ans+= pq.poll();
        }

        return ans;

    }
}