class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 0, nums, target);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int index, int[] nums, int target){
        if (target < 0){
            return;
        }

        if (target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(result, list, i, nums, target - nums[i]);
            list.removeLast();
        }
    }
}
