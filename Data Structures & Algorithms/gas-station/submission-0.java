class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int mi=0;

        for(int i=1; i<gas.length; i++){
            if(gas[i]>gas[mi]){
                mi=i;
            }
        }
        int t=0;
        int x=mi;
        for(int i=0;i<gas.length; i++){
            t+= gas[x]-cost[x];
            if(t<0){
                return -1;
            }
            x= (x+1)%gas.length;
        }

        return mi;
    }
}
