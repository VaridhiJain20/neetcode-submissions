class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                return o1[1]-o2[1];
            }
        });
        int lft=-50001;
        int cnt=0;

        for(int[] i:intervals){
            if(i[0]>= lft){
                cnt++;
                lft= i[1];
            }
        }

        return intervals.length-cnt;
    }
}