class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE, left = 0, right = heights.length - 1;
        while (left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(area, max);
            if (heights[left] < heights[right]){
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
