class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sides[]= new int[4];
        int sum=0;
        for(int i: matchsticks){
            sum+= i;
        }
        if(sum%4!=0){
            return false;
        }
        return rec(matchsticks, 0, sides, sum/4);
    }

    public boolean rec(int[] matchsticks, int idx, int[] sides, int target){

        if(idx== matchsticks.length){
            for(int t: sides){
                if(t!= target){
                    return false;
                }

            }
            return true;
        }

        for(int i=0; i<4; i++){
            if(matchsticks[idx]+sides[i]<= target){
                sides[i]+=matchsticks[idx];
                boolean r=rec(matchsticks, idx+1, sides, target);
                if(r){
                    return true;
                }
                sides[i]-=matchsticks[idx];
            }
        }

        return false;

    }
}