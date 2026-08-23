class Solution {
    public String simplifyPath(String path) {
        String[] arr= path.split("/");

        // for(String s: arr){
        //     System.out.println(s);
        // }

        String ans= "/";
        for(String s: arr){
            if(s.length()>0 && !s.equals("..") && !s.equals(".")){
                ans+= s;
                ans+="/";
            }
            if(s.equals("..")){
                int j= ans.length()-2;
                while(j>=0 && ans.charAt(j)!='/'){
                    j--;
                }
                if(j>=0){
                    ans= ans.substring(0, j+1);
                }
            }
        }

        if(ans.length()==1){
            return ans;
        }
        return ans.substring(0, ans.length()-1) ;
    }
}