class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, left[] = new int[nums.length], result[] = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--){
            result[i] = product * left[i];
            product *= nums[i];
        }

        return result;
    }
}  
