class Solution {

    public String encode(List<String> strs) {
        StringBuilder sbl = new StringBuilder();
        for (String s : strs){
            sbl.append(s.length()).append("#").append(s);
        }
        return sbl.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++; //finding length
            }
            int len = Integer.parseInt(str.substring(i,j));
            i = j + 1; //beginning of the word
            result.add(str.substring(i, i+len));
            i += len;
        }
        return result;
        
    }
}
