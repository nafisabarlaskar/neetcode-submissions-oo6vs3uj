class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = nums.length - 1;
        while (one <= two){
            if (nums[one] == 0){
                nums[one++] = nums[zero];
                nums[zero++] = 0; 
            } else if (nums[one] == 2){
                nums[one] = nums[two];
                nums[two--] = 2;
            } else {
                one++;
            }
        }
    }
}