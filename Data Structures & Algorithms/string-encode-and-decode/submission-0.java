class Solution {

    public String encode(List<String> strs) {
        String s="";

        for(String str: strs){
            s+= ""+str.length()+','+str;

        }

        return s;
    }

    public List<String> decode(String str) {
        List<String> ans= new ArrayList<>();

        int i=0;

        while(i< str.length()){
            String len="";

            while(str.charAt(i)!=','){
                len+= str.charAt(i++);
            }

            int l= Integer.parseInt(len);

            i++;
            String s="";
            for(int j=0; j<l; j++){
                s+= str.charAt(i++);
            }
            ans.add(s);
        }

        return ans;
    }
}
