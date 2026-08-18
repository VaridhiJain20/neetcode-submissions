class Solution {
    public int openLock(String[] deadends, String target) {
        
        HashSet<String> set= new HashSet<>();
        for(String d: deadends){
            set.add(d);
        }

      
        String src="0000";


          if(set.contains(target) || set.contains(src)){
            return -1;
        }

        Queue<String> q= new LinkedList<>();
        q.offer(src);
        int ans=0;
        HashSet<String> vis= new HashSet<>();

        while(!q.isEmpty()){
            int size= q.size();
            
            while(size>0){
                 String s= q.poll();
                 size--;

            if(s.equals(target)){
                return ans;
            }
            if(vis.contains(s)){
                continue;
            }
            vis.add(s);


            for(int i=0; i<4; i++){
                int n= s.charAt(i)-'0';

                String s1= s.substring(0,i)+((n+1)%10)+s.substring(i+1,4);
                String s2= s.substring(0,i)+((((n-1)%10)+10)%10)+s.substring(i+1,4);
                if(!set.contains(s1))q.offer(s1);
                if(!set.contains(s2))q.offer(s2);
            }
           
            }
            ans++;
           
        }
        return -1;
        
    }
}