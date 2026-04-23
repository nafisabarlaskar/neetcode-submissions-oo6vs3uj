class Solution {
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right, int[] temp){
        if (left >= right){
            return;
        }

        int mid = (left + right)/2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp){
        int start1 = left, start2 = mid + 1, n1 = mid - left + 1, n2 = right - mid;
        for (int i = 0; i < n1; i++){
            temp[start1 + i] = nums[start1 + i];
        }

        for (int i = 0; i < n2; i++){
            temp[start2 + i] = nums[start2 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2){
            if (temp[start1 + i] <= temp[start2 + j]){
                nums[k++] = temp[start1 + i++];
            } else {
                nums[k++] = temp[start2 + j++];
            }
        }

        while (i < n1){
            nums[k++] = temp[start1 + i++];
        }

         while (j < n2){
            nums[k++] = temp[start2 + j++];
        }
    }
}