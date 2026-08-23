class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        int cnt=0;

        while(i<j){
            if(s.charAt(i)== s.charAt(j)){
                i++;
                j--;
            }
            else{
                boolean a=check(s, i+1, j);
                boolean b=check(s, i, j-1);
                return a||b;
            }
        }

        return true;
    }
    public boolean check(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!= s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}