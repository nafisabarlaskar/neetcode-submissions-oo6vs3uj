class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums){
            totalSum += num;
        }

        if (totalSum % k != 0){
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) { 
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return dfs(nums, 0, 0, 0, totalSum/k, k, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int index, int sum, int count, int target, int k, boolean[] visited){
        if (count == k - 1){
            return true;
        }

        if (sum > target){
            return false;
        }

        if (sum == target){
            return dfs(nums, 0, 0, count + 1, target, k, visited);
        }

        for (int i = index; i < nums.length; i++){
            if (!visited[i]){
                visited[i] = true;
                if (dfs(nums, i + 1, sum + nums[i], count, target, k, visited)){
                    return true;
                }

                visited[i] = false;
            }
        }

        return false;
    }
}