class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> freq= new HashMap<>();

        for(int i:hand){
            freq.put(i, freq.getOrDefault(i,0)+1);

        }

        Arrays.sort(hand);
        
        for(int i:hand){
            if(freq.get(i)<1){
                continue;
            }
          
            freq.put(i, freq.get(i)-1);

            for(int j=1; j<groupSize;j++){
                if(!freq.containsKey(i+j)|| freq.get(i+j)<1){
                    return false;
                }
                 freq.put(i+j, freq.get(i+j)-1);
            }
            
        }

        return true;
    }
}