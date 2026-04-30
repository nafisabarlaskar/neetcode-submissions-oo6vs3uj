class Solution {
    int result = 0;
    public int subsetXORSum(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return result;
    }

    private void dfs(int i, int[] nums, List<Integer> list){
        int xor = 0;
        for (int num : list){
            xor ^= num;
        }

        result += xor;
        for (int j = i; j < nums.length; j++){
            list.add(nums[j]);
            dfs(j + 1, nums, list);
            list.removeLast();
        }
    }
}