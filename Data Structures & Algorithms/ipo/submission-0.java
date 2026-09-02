class Solution {
    public class pair{
        int p; 
        int c;

        public pair(int p, int c){
            this.p= p;
            this.c= c;
        }
    }


    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<pair> pq= new PriorityQueue<>(new Comparator<pair>(){
            @Override
            public int compare(pair o1, pair o2){
                
                return o2.p-o1.p;
            }
    });

        int[][] arr= new int[profits.length][2];

        for(int i=0; i<arr.length; i++){
            arr[i][0]= profits[i];
            arr[i][1]= capital[i];
        }

        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                
                return o1[1]-o2[1];
            }
    });

int cnt=0;

 int i=0;
        while(cnt<k ){
            while(i<arr.length && arr[i][1]<=w){
             pq.offer(new pair(arr[i][0],arr[i][1]));
             i++;
            }
            if(!pq.isEmpty()){
                w+= pq.poll().p;
                cnt++;
            }
            else{
                break;
            }

            
        }

        return w;
    }
}