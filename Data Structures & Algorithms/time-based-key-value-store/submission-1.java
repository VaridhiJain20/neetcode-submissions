class TimeMap {
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map= new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)|| map.get(key).size()==0){
            return "";
        }

        Integer ts= map.get(key).floorKey(timestamp);
        if(ts==null){
            return "";
        }
        return map.get(key).get(ts);
    }
}
