class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int target, int index){
        if (target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0){
            return;
        }

        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }
            
            list.add(nums[i]);
            dfs(result, list, nums, target - nums[i], i + 1);
            list.removeLast();
        }
    }
}
