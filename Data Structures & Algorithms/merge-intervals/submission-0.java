class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                return o1[0]-o2[0];
            }
        });

        ArrayList<int[]> l= new ArrayList<>();
        int si= intervals[0][0];
        int ei= intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            
            if(intervals[i][0]> ei){
                l.add(new int[]{si , ei});
                si= intervals[i][0];
                ei= intervals[i][1];
           
            }
            else{
                ei= Math.max(ei, intervals[i][1]);
            }
        }
        l.add(new int[]{si , ei});

        int[][] ans= new int[l.size()][2];
        int i=0;
        for(int [] a: l){
            ans[i++]=a;
        }

        return ans;
    }
}
