class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize first window
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int l = 0;

        // Slide the window - r represents element to add to the window
        for (int r = s1.length(); r < s2.length(); r++) {

            // Check current window
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }

            // Add character entering the window
            s2Count[s2.charAt(r) - 'a']++;

            // Remove character leaving the window
            s2Count[s2.charAt(l) - 'a']--;

            l++;
        }

        // Check final window
        return Arrays.equals(s1Count, s2Count);
    }
}
