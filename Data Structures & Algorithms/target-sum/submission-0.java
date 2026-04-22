class Solution {
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        for (int num : nums){
            total += num;
        }

        int[][] dp = new int[nums.length][2 * total + 1];
        for (int[] d : dp){
            Arrays.fill(d, Integer.MIN_VALUE);
        }

        return dfs(nums, target, dp, 0, 0);
    }

    private int dfs(int[] nums, int target, int[][] dp, int i, int sum){
        if (i == nums.length){
            return sum == target ? 1 : 0;
        }

        if (dp[i][sum + total] != Integer.MIN_VALUE){
            return dp[i][sum + total];
        }

        int add = dfs(nums, target, dp, i + 1, sum + nums[i]);
        int subtract = dfs(nums, target, dp, i + 1, sum - nums[i]);
        return dp[i][sum + total] = add + subtract;
    }
}
