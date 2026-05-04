class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMin = 0, currMax = 0, minSum = nums[0], maxSum = nums[0], total = 0;
        for (int num : nums){
            total += num;
            currMax = Math.max(currMax, 0) + num;
            currMin = Math.min(currMin, 0) + num;
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
        } 

        return total == minSum ? maxSum : Math.max(total - minSum, maxSum);
    }
}