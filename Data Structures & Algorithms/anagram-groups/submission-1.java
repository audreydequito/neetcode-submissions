class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs.length==0){
            return new ArrayList();
        }

        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        
        for (String s: strs){
            Arrays.fill(count, 0); //initializes array with all 0s

            for(char c : s.toCharArray()){
                count[c-'a']++; //makes the array of occurrences of each letter
            }

            StringBuilder sb = new StringBuilder(""); 
            //creates new mutable object that doens't create a new object       everytime you change it

            for (int i = 0; i<26; i++){
                sb.append("#"); //append a # because if a word has 12 c's and 1 d can be same as if a word has 1 c, 2 d's, and 1 e
                sb.append(count[i]); // creates the hashing we need for strings
            }

            String key = sb.toString(); //converts the builder to a string

            if (!ans.containsKey(key)){  //if the map doesn't already contain the key, meaning we haven't seen any anagrams of the current string
                ans.put(key, new ArrayList<>()); //put the new key into the map and create an empty arraylist
            }

            ans.get(key).add(s); //add the current string to the arraylist with the correct key hashing 

        }
        return new ArrayList<>(ans.values()); //return a new arraylist with all of the values which are each arraylists of anagrams
    }
}