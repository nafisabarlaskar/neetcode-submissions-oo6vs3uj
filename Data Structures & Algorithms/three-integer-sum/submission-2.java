class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                sum(result, i, nums);
            }
        }

        return result;
    }

    private void sum(List<List<Integer>> result, int i, int[] nums){
        int low = i + 1, high = nums.length - 1;
        while (low < high){
            int sum = nums[i] + nums[low] + nums[high];
            if (sum == 0){
                result.add(List.of(nums[i], nums[low], nums[high]));
                while (low < high && nums[low] == nums[low + 1]){
                    low++;
                }

                low++;
                high--;
            } else if (sum < 0){
                low++;
            } else {
                high--;
            }
        }
    }
}
