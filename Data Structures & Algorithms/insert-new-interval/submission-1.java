class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals){
            if (newInterval[0] > interval[1]){
                list.add(interval);
            } else if (newInterval[1] >= interval[0]){
                newInterval = new int[] {Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])};
            } else {
                list.add(newInterval);
                newInterval = interval;
            }
        }

        list.add(newInterval);
        return list.toArray(new int[list.size()][2]);
    }
}
