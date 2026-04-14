class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int index){
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i - 1]){
                continue;
            }

            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.removeLast();
        }
    }
}
