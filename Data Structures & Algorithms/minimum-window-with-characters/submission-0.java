class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";
        }
     HashMap<Character, Integer> need= new HashMap<>();
     HashMap<Character, Integer> window= new HashMap<>();

    for(char c: t.toCharArray()){
        need.put(c, need.getOrDefault(c,0)+1);            
    }
    int n= t.length();
    int have=0;

    int r=0;

    int l=0;
    int ans=Integer.MAX_VALUE;
    String rv="";

    for(r=0; r<s.length(); r++){
        char c=s.charAt(r);
        if(need.containsKey(c)){
        window.put(c, window.getOrDefault(c,0)+1); 
        if(need.get(c)>= window.get(c)){
            have++;
        }
        if(have==n){
               while(l<=r){
    char ch= s.charAt(l);
    if(need.containsKey(ch)){
        if(need.get(ch)<window.get(ch)){
             window.put(ch, window.get(ch)-1);
        }
        else{
            break;
        }
    }
l++;
    }

    if(ans>r-l+1){
        ans=r-l+1;
        rv= s.substring(l, r+1);

    }
        }
        }
    }

  
 
    
    return rv;
    }
}
