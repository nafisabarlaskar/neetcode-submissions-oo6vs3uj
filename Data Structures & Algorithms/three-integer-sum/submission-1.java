class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                sum(nums, i, result);
            }
        }

        return result;
    }

    private void sum(int[] nums, int index, List<List<Integer>> result){
        int low = index + 1, high = nums.length - 1;
        while (low < high){
            int sum = nums[index] + nums[low] + nums[high];
            if (sum == 0){
                result.add(Arrays.asList(nums[index], nums[low++], nums[high--]));
                while (low < high && nums[low] == nums[low - 1]){
                    low++;
                }
            } else if (sum < 0){
                low++;
            } else {
                high--;
            }
        }
    }
}
