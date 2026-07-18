class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l= new ArrayList<>();
        boolean added= false;

        for(int[]i: intervals){
            if(i[1]<= newInterval[0]){
                l.add(i);
            }
            else if(i[0]>=newInterval[1]){
                if(!added){
                l.add(newInterval);
                added= true;
                }            
                l.add(i);
            }
            else{
                newInterval[0]= Math.min(newInterval[0],i[0]);
                newInterval[1]= Math.max(newInterval[1],i[1]);
            }
        }

         if(!added){
                l.add(newInterval);
                added= true;
                }     

        int[][]ans= new int[l.size()][2];
        int idx=0;
        for(int[] i:l){
            ans[idx++]= i;
        }

        return ans;
    }
}
