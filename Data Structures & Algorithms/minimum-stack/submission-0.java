class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()){
            stack.push(new int[] {val, val});
        } else {
            stack.push(new int[] {val, Math.min(stack.peek()[1], val)});
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
