class Solution {
    public String convertToTitle(int columnNumber) {
        int a= columnNumber;
        String ans="";
        while(a>0){
            int i=a%26;
            if(i==0){
                i=26;
            }
            char c= (char)((int)'A'+(i -1));
            ans= c+ans; 
            a= (a-1)/26;    
        }

        return ans;
    }
}