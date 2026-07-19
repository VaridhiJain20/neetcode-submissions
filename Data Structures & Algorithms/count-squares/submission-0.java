class CountSquares {
    HashMap<String, Integer> map;
 

    public CountSquares() {
    map= new HashMap<>();   
    }
    
    public void add(int[] point) {
        String str= ""+point[0]+","+point[1];
        map.put(str, map.getOrDefault(str,0)+1);        
    }
    
    public int count(int[] point) {
        int x= point[0];
        int y= point[1];

        int cnt=0;

        for(String c: map.keySet()){
            String[] parts = c.split(",");
            int cx = Integer.parseInt(parts[0]);
            int cy = Integer.parseInt(parts[1]);

            if(x==cx || y==cy)continue;
            if(Math.abs(cx-x) == Math.abs(cy-y)){
                String c1=""+x+","+cy;
                String c2=""+cx+","+y;
                if(map.containsKey(c1) && map.containsKey(c2) ){
                    cnt+=( map.get(c)* map.get(c1)*map.get(c2));
                }
            }
        }

        return cnt;
    }
}
