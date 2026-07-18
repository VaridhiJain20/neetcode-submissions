class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int strt=0;

        int tank=0;
        int total=0;

        for(int i=0; i<gas.length; i++){
            tank+= gas[i]-cost[i];
            total+= gas[i]-cost[i];

            if(tank<0){
                strt=i+1;
                tank=0;
            }
        }

        if(total<0){
            return -1;
        }

        return strt;
    }
}
