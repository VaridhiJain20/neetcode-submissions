class Solution {
    public boolean isAnagram(String s, String t) {
        char[]c1= s.toCharArray();
        char[]c2= t.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        s= new String(c1);
        t= new String(c2);

        return s.equals(t);
    }
}
