class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length, left = 0, right = m, min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        while (left <= right){
            int mid1 = (left + right)/2, mid2 = (n + m + 1)/2 - mid1;
            int maxLeft1 = mid1 == 0 ? min : nums1[mid1 - 1], maxLeft2 = mid2 == 0 ? min : nums2[mid2 - 1];
            int minRight1 = mid1 == m ? max : nums1[mid1], minRight2 = mid2 == n ? max : nums2[mid2];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                if ((m + n) % 2 == 0){
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > maxLeft2){
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return 0.0;
    }
}
