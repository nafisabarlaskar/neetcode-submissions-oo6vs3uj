class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0){
            return false;
        }

        int subsetSum = sum/2;
        boolean[] arr = new boolean[subsetSum + 1];
        arr[0] = true;
        for (int num : nums){
            for (int j = subsetSum; j >= num; j--){
                arr[j] = arr[j] || arr[j - num];
            }
        }

        return arr[subsetSum];
    }
}
