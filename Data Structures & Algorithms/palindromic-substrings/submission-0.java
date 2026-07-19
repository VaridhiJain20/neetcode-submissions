class Solution {
    public int countSubstrings(String s) {
        int cnt=0;

        for(int i=0; i< s.length(); i++){
            int j=0;
            while(i-j>=0 && i+j<s.length()){
                if(s.charAt(i-j)== s.charAt(i+j)){
                    cnt++;
                    j++;
                }
                else{
                    break;
                }
            }
        }

        for(int i=0; i< s.length(); i++){
            int j=0;
            while(i-j>=0 && i+j+1<s.length()){
                if(s.charAt(i-j)== s.charAt(i+j+1)){
                    cnt++;
                    j++;
                }
                else{
                    break;
                }
            }
        }

        return cnt;
    }
}