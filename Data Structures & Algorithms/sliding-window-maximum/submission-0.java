class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = nums.length, i = 0, result[] = new int[n - k + 1];
        while (i < n){
            while (!stack.isEmpty() && stack.peekFirst() == i - k){
                stack.removeFirst();
            }

            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]){
                stack.removeLast();
            }

            stack.offer(i);
            if (i + 1 - k >= 0){
                result[i - k + 1] = nums[stack.peek()];
            }
            
            i++;
        }

        return result;
    }
}
