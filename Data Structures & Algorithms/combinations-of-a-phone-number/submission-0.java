class Solution {
    
   char[][] map = {
        {}, {}, 
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
       public List<String> letterCombinations(String digits) {
        
        List<String>ans= new ArrayList<>();

        if(digits.length()==0){
            return ans;
        }

        rec(digits, 0,"", ans);
return ans;
    }

    public void rec(String digits, int i, String s, List<String>ans){
        if(i==digits.length()){
            ans.add(s);
            return;
        }

        int d= digits.charAt(i)-'0';

        for(int j=0; j<map[d].length; j++){
            rec(digits, i+1,s+map[d][j], ans);
        }
    }
}
