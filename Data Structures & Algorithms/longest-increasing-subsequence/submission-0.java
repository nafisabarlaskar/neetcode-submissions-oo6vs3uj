class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++){
            int lastElement = list.getLast();
            if (nums[i] > lastElement){
                list.add(nums[i]);
            } else {
                list.set(binarySearch(list, nums[i]), nums[i]);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int target){
        int low = 0, high = list.size();
        while (low < high){
            int mid = low + (high - low)/2;
            if (list.get(mid) == target){
                return mid;
            } else if (list.get(mid) < target){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
