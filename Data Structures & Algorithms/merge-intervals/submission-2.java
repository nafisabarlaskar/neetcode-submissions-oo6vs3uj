class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > prev[1]){
                list.add(prev);
                prev = intervals[i];
            } else {
                prev = new int[] {Math.min(intervals[i][0], prev[0]), Math.max(prev[1], intervals[i][1])};
            }
        }

        list.add(prev);
        return list.toArray(new int[list.size()][2]);
    }
}
