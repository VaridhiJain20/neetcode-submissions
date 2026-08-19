class Solution {
    public int maxTurbulenceSize(int[] arr) {
int l=0;
int ans=1;

for(int r=1; r< arr.length; r++){
    if(arr[r]==arr[r-1]){
        l=r;
    }
    else if(r>=2){
        int d=1;
        if(arr[r-1]> arr[r]){
            d=-1;
        }
        int ld=1;
        if(arr[r-2]> arr[r-1]){
            ld=-1;
        }
        else if(arr[r-2]==arr[r-1]){
            ld=0;
        }

        if(ld*d!=-1){
            l=r-1;
        }

    }
    ans=Math.max(ans, r-l+1);
}

return ans;

    }
}