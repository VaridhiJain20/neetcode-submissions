class Solution {
    public long minEnd(int n, int x) {
        int a= x;
        ArrayList<Integer> arr= new ArrayList<>();
        while(a>0){
            arr.addFirst(a&1);
            a= a>>1;
        }

        int b= n-1;

        for(int i= arr.size()-1; i>=0; i--){
            if(arr.get(i)==1){
                continue;
            }
            arr.set(i,b&1);
            b=b>>1;
        }
        while(b>0){
            arr.addFirst(b&1);
            b=b>>1;
        }
        long ans=0;

        for(int c: arr){
            ans= (ans<<1)+c;
        }

        return ans;
    }
}