class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums){
            if (!list.contains(num)){
                list.add(num);
                dfs(result, list, nums);
                list.removeLast();
            }
        }
    }
}
