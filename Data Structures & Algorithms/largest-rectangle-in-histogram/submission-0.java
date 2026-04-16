class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE, n = heights.length, i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < n){
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        while (!stack.isEmpty()){
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
