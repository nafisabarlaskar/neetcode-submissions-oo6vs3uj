class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE, left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target){
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }

            right++;
        }

        return result != Integer.MAX_VALUE ? result : 0;
    }
}