class Solution {
    public boolean isValid(String s) {
        Deque<Character> chars = new ArrayDeque<>();
        for (char x : s.toCharArray()){
            if (x == '(' || x == '{'|| x == '[' ){
                chars.push(x);
            } else {
                if (chars.isEmpty()) return false;
                if (x == ')'){
                    if (chars.pop() != '(') return false;
                }
                if (x == '}'){
                    if (chars.pop() != '{') return false;
                }
                if (x == ']'){
                    if (chars.pop() != '[') return false;
                }
            }
        }
        return chars.isEmpty();
    }
}
