class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums){
            sum += num;
            max = Math.max(max, num);
        }

        int low = max, high = sum, minLargestSplitSum = 0;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (minSubArrLessThanK(nums, mid, k)){
                high = mid - 1;
                minLargestSplitSum = mid;
            } else {
                low = mid + 1;
            }
        }

        return minLargestSplitSum;
    }

    private boolean minSubArrLessThanK(int[] nums, int maxSum, int k){
        int sum = 0, splitsRequired = 0;
        for (int num : nums){
            sum += num;
            if (sum > maxSum){
                splitsRequired++;
                sum = num;
            }
        }

        return splitsRequired + 1 <= k;
    }
}