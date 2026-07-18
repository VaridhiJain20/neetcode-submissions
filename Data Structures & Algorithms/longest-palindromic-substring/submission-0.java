class Solution {
    public String longestPalindrome(String s) {
        
        int len= 0;
        String ans="";

        for(int i=0; i<s.length(); i++){
            int j=0;
            
            while(i-j>=0 && i+j<s.length()){
                if(s.charAt(i-j)== s.charAt(i+j)){
                    if(len<2*j+1){
                        len= 2*j+1;
                        ans= s.substring(i-j, i+j+1);
                    }
                }
                else{
                    break;
                }
                j++;
            }
        }

         for(int i=0; i<s.length()-1; i++){
            int j=1;
            
            while(i-j+1>=0 && i+j<s.length()){
                if(s.charAt(i-j+1)== s.charAt(i+j)){
                    if(len<2*j){
                        len= 2*j;
                        ans= s.substring(i-j+1, i+j+1);
                    }
                }
                else{
                    break;
                }
                j++;
            }
        }

        return ans;
    }
}