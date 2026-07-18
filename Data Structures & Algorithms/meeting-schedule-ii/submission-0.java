/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    int cnt;

    public int minMeetingRooms(List<Interval> intervals) {

        if(intervals.size()<1){
            return 0;
        }

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start-o2.start;
            }
        });

        PriorityQueue<Integer> pq= new PriorityQueue<>();
        cnt=1;
        pq.offer(intervals.get(0).end);

        for(int i=1; i<intervals.size(); i++){
            int et=pq.poll();

            if(intervals.get(i).start<et){
                cnt++;
                pq.offer(et);
               
            }
             pq.offer(intervals.get(i).end);
          
        }

        return cnt;

    }
}
