class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
          if(nums1.length< nums2.length){
            return bs(nums1, nums2);
        }

        else{
            return bs(nums2, nums1);
        }
    }

    public double bs (int[] nums1, int[] nums2){
        int m= nums1.length;
        int n= nums2.length;

        int c= (n+m+1)/2;

        int lo=-1;
        int hi= nums1.length-1;
        
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;

            int x= c-mid-2;

            int l1= Integer.MIN_VALUE;
             if(mid>=0){
                l1= nums1[mid];
            }
            int r1= Integer.MAX_VALUE;
            if(mid+1<=nums1.length-1){
                r1= nums1[mid+1];
            }


            int l2= Integer.MIN_VALUE;
             if(x>=0){
                l2= nums2[x];
            }
            int r2= Integer.MAX_VALUE;
            if(x+1<=nums2.length-1){
                r2= nums2[x+1];
            }
           
           if(l1<=r2 && l2<=r1){
                if((n+m)%2==1){
                    return Math.max(l1,l2);
                }
                else{
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
           }
           if(l1>r2){
            hi= mid-1;
           }
           else{
            lo= mid+1;
           }

        }

        return 0;
    }
}
