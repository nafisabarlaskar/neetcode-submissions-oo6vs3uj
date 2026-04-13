class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int result = 0, prev = Integer.MIN_VALUE;
        for (int[] interval : intervals){
            if (interval[0] >= prev){
                prev = interval[1];
            } else {
                result++;
            }
        }

        return result;
    }
}
