class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, right[] = new int[nums.length];
        if (nums.length == 0){
            return right;
        }

        right[0] = 1;
        for (int i = 1; i < nums.length; i++){
            right[i] = nums[i - 1] * right[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--){
            right[i] *= product;
            product *= nums[i];
        }

        return right;
    }
}  
