class Solution {
    public int characterReplacement(String s, int k) {
        int l=0;
        int r=0;
        int max_freq=0;
        int ans=0;
        int[]freq= new int[26];

        while(r<s.length() && l<=r){
            freq[s.charAt(r)-'A']++;
            max_freq= Math.max(freq[s.charAt(r)-'A'], max_freq);

            int ws= r-l+1;
            int nor= ws-max_freq;
            if(nor>k){
                  freq[s.charAt(l)-'A']--;
          
            l++;
            }
            else{
                ans= Math.max(ans, ws);
              
            }
              r++;
        }

        return ans;
    }
}
