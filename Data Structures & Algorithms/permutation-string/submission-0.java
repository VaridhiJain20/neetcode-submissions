class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] window = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int k = s1.length();

        // First window of size s1.length()
        for (int i = 0; i < k; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(count1, window)) {
            return true;
        }

        // Slide the window
        for (int right = k; right < s2.length(); right++) {

            // Add new character
            window[s2.charAt(right) - 'a']++;

            // Remove leftmost character
            int left = right - k;
            window[s2.charAt(left) - 'a']--;

            if (Arrays.equals(count1, window)) {
                return true;
            }
        }

        return false;
    }
}