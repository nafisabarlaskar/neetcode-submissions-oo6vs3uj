class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0], end = newInterval[1];
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals){
            if (interval[1] < start){
                list.add(interval);
            } else if (interval[0] <= end){
                end = Math.max(end, interval[1]);
                start = Math.min(start, interval[0]);
            } else {
                list.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            }
        }

        list.add(new int[] {start, end});
        return list.toArray(new int[list.size()][2]);
    }
}
