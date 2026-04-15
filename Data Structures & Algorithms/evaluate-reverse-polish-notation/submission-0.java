class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int result = 0;
        for (String str : tokens){
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                int b = stack.pop(), a = stack.pop();
                stack.push(a - b);
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                int b = stack.pop(), a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        while (!stack.isEmpty()){
            result += stack.pop();
        }

        return result;
    }
}
