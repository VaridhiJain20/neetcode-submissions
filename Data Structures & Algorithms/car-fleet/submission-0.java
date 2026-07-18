class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(speed.length==1){
            return 1;
        }
        int[][] arr= new int[speed.length][2];

        for(int i=0; i<arr.length; i++){
            arr[i][0]=position[i];
            arr[i][1]= speed[i];
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[]o1, int[]o2){
                return o2[0]-o1[0];
            }
        });

        int nof=1;
        double lt= ((double)target-arr[0][0])/ arr[0][1];

        for(int i=1; i<arr.length; i++){
            double t=((double)target-arr[i][0])/ arr[i][1];
            if(t>lt){
                nof++;
                lt=t;
            }
        }

        return nof;
    }
}
