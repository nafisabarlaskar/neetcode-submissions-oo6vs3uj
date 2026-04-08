class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int target, int idx){
        if (target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0){
            return;
        }

        for (int i = idx; i < nums.length; i++){
            list.add(nums[i]);
            dfs(result, list, nums, target - nums[i], i);
            list.removeLast();
        }
    }
}
