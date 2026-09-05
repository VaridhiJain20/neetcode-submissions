class Solution {
    HashSet<String> set;
    HashMap<Integer, List<String>> dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        for(String str: wordDict){
            set.add(str);
        }

        dp= new HashMap<>();

        return fn(s, 0);


    }

    public List<String> fn(String s, int idx){
        if(idx== s.length()){
            List<String> rv= new ArrayList<>();
            rv.add("");
            return rv;
        } 

        if(dp.containsKey(idx)){
            return dp.get(idx);
        }      

        List<String> ans= new ArrayList<>(); 

        for(int i=idx+1; i<= s.length(); i++){
            String ss= s.substring(idx, i);
            if(!set.contains(ss)){
                continue;
            }

            List<String> l= fn(s, i);
            for(String str: l){
                if(str.equals("")){
                    ans.add(ss);
                }
                else{
                    ans.add(ss+" "+str);
                }
            }


        }
        dp.put(idx, ans);

        return ans;
    }
}