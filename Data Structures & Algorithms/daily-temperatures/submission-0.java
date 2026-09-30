class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        /*
        find a j where temps[j] > temps[i] (first j)
        then we want the result[i] = j-i

        if there is no such j then we replace
        result[i] = 0

        STACK = Last In First Out,

        38

        update result[0] = 1
        for each element add the element to the stack until 
        one is popped because that means that monotonic Stack

        higher to lower

        for example, 30 -> 38 30 -> but 38 is popped because its out of order so 
        only one is on the stack 

        38 -> 30 38 -> 36 30 38 // this is a violation


        instead of doing it for each just do it for all of the above

        keep adding all elements to the stack until you reach a pop

        30 38 so we have to pop which gives us [0] = 1
        38 30 so we 
        */

        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{temp, i});
        }
        return res;

    }
}
