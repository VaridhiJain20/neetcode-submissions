class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int hi=0;
        int lo=weights[0];

        for(int w: weights){
            hi+=w;
            lo= Math.max(lo, w);
        }

        int ans=hi;

        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPoss(weights, days, mid)){
                ans= mid;
                hi= mid-1;
            }
            else{
                lo= mid+1;
            }
        }

        return ans;
    }

    public boolean isPoss(int[] weights, int days, int c){
        int rc=0;
        int dc=1;

        for(int w: weights){
            if(rc+w<= c){
                rc+=w;
            }
            else{
                dc++;
                rc=w;
            }
        }

        return dc<=days;
    }
}