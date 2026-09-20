class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if ((c == ')' && stack.peek() != '(') ||
                (c == '}' && stack.peek() != '{') ||
                (c == ']' && stack.peek() != '[')) {
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}