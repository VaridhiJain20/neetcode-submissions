class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxF=0;
        int maxC=0;

        HashMap<Character, Integer> freq= new HashMap<>();

        for(char c: tasks){
            freq.put(c, freq.getOrDefault(c,0)+1);

            if(freq.get(c)>maxF){
                maxF= freq.get(c);
                maxC=1;
            }
            else if(freq.get(c)==maxF){
                maxC++;
            }
        }


        int ans= ((n+1)*(maxF-1))+ maxC;

        return Math.max(tasks.length, ans);
    }
}
