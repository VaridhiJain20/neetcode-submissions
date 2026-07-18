class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] occ= new int[26][2];

        for(int i=0; i<26; i++){
            occ[i][0]=-1;
            occ[i][1]=-1;
        }

        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);

            if(occ[c-'a'][0]==-1){
                occ[c-'a'][0]=i;
                occ[c-'a'][1]=i;
            }
            else{
                occ[c-'a'][1]=i;
            }
        }

        Arrays.sort(occ, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                
                return o1[0]-o2[0];
            }
        });

        List<Integer> ans= new ArrayList<>();
        int li=-1;

        int i=0;
        while(i<26 && occ[i][1]==-1){
            i++;
        }

        int si=occ[i][0];
        int ei=occ[i][1];
        i++;

        while(i<26){
            if(occ[i][0]<ei){
              ei= occ[i][1];
            }
            else{
              ans.add(ei-si+1);
              si= occ[i][0];
              ei= occ[i][1];
            }
            i++;
        }
        ans.add(ei-si+1);
    return ans;
    }
}
