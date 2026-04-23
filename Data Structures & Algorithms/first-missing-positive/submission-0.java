class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if (nums[i] <= 0 || nums[i] == i + 1 || nums[i] > nums.length){
                i++;
            } else if (nums[i] != nums[nums[i] - 1]){
                int temp = nums[i];
                int j = nums[i] - 1;
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                i++;
            }
        }

        i = 0;
        while (i < nums.length && i + 1 == nums[i]){
            i++;
        }

        return i + 1;
    }
}