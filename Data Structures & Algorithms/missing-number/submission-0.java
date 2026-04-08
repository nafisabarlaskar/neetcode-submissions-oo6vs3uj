class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, num = 0;
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++){
            num ^= (i ^ nums[i - 1]);
        }

        return num;
    }
}
