class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high){
            int mid = low + (high - low)/2;
            double num = Integer.MAX_VALUE;
            if ((nums[0] > target) == (nums[0] > nums[mid])) {
                num = nums[mid];
            } else if (target < nums[0]){
                num = -Integer.MAX_VALUE;
            }

            if (target < num){
                high = mid;
            } else if (target > num){
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
