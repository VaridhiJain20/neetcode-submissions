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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.end-o2.end;
            }
        });
        int lft=-1;

        for(Interval i: intervals){
            if(i.start<lft){
                return false;
            }
            lft= i.end;
        }

        return true;
    }
}
