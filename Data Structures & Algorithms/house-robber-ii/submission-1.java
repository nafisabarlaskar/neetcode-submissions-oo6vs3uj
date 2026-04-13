class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }

        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    private int rob(int[] nums, int start, int end){
        int sum2 = 0, sum1 = 0;
        for (int i = start; i <= end; i++){
            int max = Math.max(sum1, nums[i] + sum2);
            sum2 = sum1;
            sum1 = max;
        }

        return sum1;
    }
}
