class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++){
            int last = list.getLast();
            if (nums[i] > last){
                list.add(nums[i]);
            } else {
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }

        return list.size();
    }

    private int binarySearch(List<Integer> list, int target){
        int low = 0, high = list.size() - 1;
        while (low < high){
            int mid = low + (high - low)/2;
            if (list.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
