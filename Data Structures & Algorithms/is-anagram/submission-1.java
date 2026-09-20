class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sfreq = new HashMap<>();
        HashMap<Character, Integer> tfreq = new HashMap<>();

        for (char x : s.toCharArray()){
            sfreq.put(x, sfreq.getOrDefault(x, 0) + 1);
        }

        for (char x : t.toCharArray()){
            tfreq.put(x, tfreq.getOrDefault(x, 0) + 1);
        }

        return sfreq.equals(tfreq);

    }
}
