class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        	        HashMap<String, List<String>> map= new HashMap<>();
	        
	        for (int i = 0; i < strs.length; i++) {
				char[] arr= strs[i].toCharArray();
				Arrays.sort(arr);
				
				String s= new String(arr);
				
				map.putIfAbsent(s, new ArrayList());
			    map.get(s).add(strs[i]);
			}
	        
	        
	        List<List<String>> ans= new ArrayList<>();
	        
	        for(String s: map.keySet()) {
	        	
	        	ans.add(map.get(s));
	        }
	        
	        return ans;
    }
}