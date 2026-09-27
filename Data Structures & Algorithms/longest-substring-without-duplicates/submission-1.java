class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for (int i = 0; i < s.length(); i++){
            HashSet<Character> set = new HashSet<>();
            int length = 0;
            int curr = i;
            while (curr < s.length() && !set.contains(s.charAt(curr))){
                set.add(s.charAt(curr));
                length++;
                curr++;
            }
            if (length > max){
                max = length;
            }
        }

        return max;
    }
}
