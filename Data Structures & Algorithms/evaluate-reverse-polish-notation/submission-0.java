class Solution {
    public int evalRPN(String[] tokens) {
        /*
        ans = 

        stack is last in first out = 2 1

        whenever we encounter + * - or / 
        
        temp = stack.pop()
        stack.push((stack.pop() op temp,))

        stack.push(1+2) // 3

        // 3 3

        *

        temp = 3
        stack.push(3 * 3)

        // 4 9 

        temp = 4
        stack.push(9 - 4)

        */

        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens){
            int temp;
            if (token.equals("+")){
                temp = stack.pop();
                stack.push(stack.pop() + temp);
            } else if (token.equals("-")){
                temp = stack.pop();
                stack.push(stack.pop() - temp);
            } else if (token.equals("*")){
                temp = stack.pop();
                stack.push(stack.pop() * temp);
            } else if (token.equals("/")){
                temp = stack.pop();
                stack.push(stack.pop() / temp);
            } else { //means its a string int
                stack.push(Integer.parseInt(token));
                // add it to the stack
            }
        }

        return stack.pop();

    }
}
