class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times){
            graph.computeIfAbsent(time[0], p -> new ArrayList<>()).add(new int[] {time[1], time[2]});
        }

        int time = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Set<Integer> visited = new HashSet<>();
        q.add(new int[] {k, 0});
        while (!q.isEmpty()){
            int[] node = q.poll();
            if (!visited.add(node[0])) {
                continue;
            }

            time = Math.max(time, node[1]);
            for (int[] neighbor : graph.getOrDefault(node[0], new ArrayList<>())){
                q.add(new int[] {neighbor[0], node[1] + neighbor[1]});
            } 
        }

        return visited.size() == n ? time : -1;
    }
}
