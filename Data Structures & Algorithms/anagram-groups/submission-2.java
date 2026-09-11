class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        thought process:
        - create an array of 26 characters each one represents a Character
        - add the counts for each word
        - create a string based on the array of the 26 characters for each word
        - add the string to the hashmap 
        - anagrams have the same number of characters for each so it would generate the 
        same key
        - if not in the hashmap already create an empty List then add
        - if in the hasmap then just add to the list

        int[] count = new int[26]
        thought make a HashMap<String, List<String>> = new HashMap<>()
        StringBuilder sbl = new StringBuilder()
        */ 
        
        Map<String, List<String>> pairs = new HashMap<>();

        for (String s: strs) {
        
        int[] count = new int[26];
        Arrays.fill(count, 0);

        for (char c : s.toCharArray()){
            count[c-'a']++;
        }

        StringBuilder sbl = new StringBuilder();
        for (int i : count){
            sbl.append(i);
            sbl.append("#");
        }
        String key = sbl.toString();

        if (!pairs.containsKey(key)){
            pairs.put(key, new ArrayList<>());
        }
        pairs.get(key).add(s);

        }

        List<List<String>> ans = new ArrayList<>(pairs.values());

        return ans;
    }
}
