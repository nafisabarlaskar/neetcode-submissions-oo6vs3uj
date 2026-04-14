class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int index){
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++){
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.removeLast();
        }
    }
}
