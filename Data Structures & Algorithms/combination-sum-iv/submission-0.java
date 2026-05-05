class Solution {
    Map<Integer, Integer> memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int target){
        if (target == 0){
            return 1;
        }

        if (memo.containsKey(target)){
            return memo.get(target);
        }

        int result = 0;
        for (int num : nums){
            if (target - num >= 0){
                result += dfs(nums, target - num);
            }
        }

        memo.put(target, result);
        return result;
    }
}