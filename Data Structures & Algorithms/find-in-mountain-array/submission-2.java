/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak= peak(mountainArr);
        if(peak==-1){
            return -1;
        }

        int l= bs(mountainArr, 0, peak, target, 0);
        if(l!=-1){
            return l;
        }
        return bs(mountainArr, peak, mountainArr.length()-1, target, 1);
    }

    public int bs(MountainArray arr, int si, int ei, int target, int h){
        int lo= si; 
        int hi= ei;

        while(lo<=hi){
            int mid= lo+(hi-lo)/2; 
            int n= arr.get(mid);
            if(n==target){
                return mid;
            }
            else if(n<target){
                if(h==0){
                    lo= mid+1;

                }
                else{
                    hi= mid-1;
                }
                
            }
            else{
                if(h==0){
                    hi= mid-1;
                }
                else{
                    lo= mid+1;
                }
                
            }

        }
        return -1;
    }

    public int peak(MountainArray arr){
        int lo=0;
        int hi= arr.length()-1;

        while(lo<hi){
            int mid= lo+(hi-lo)/2;
          
                int b= arr.get(mid);
                int c= arr.get(mid+1);
                
                if(b<c){
                    lo= mid+1;
                }
                else{
                    hi= mid;
                }
            
        }

        return lo;
    }
}