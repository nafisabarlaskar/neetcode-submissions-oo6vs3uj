class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length, left = 0;
        int[] arr = new int[2 * n];
        for (int num : nums){
            arr[left] = num;
            arr[left++ + n] = num;
        }

        return arr;
    }
}