class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights){
            map.computeIfAbsent(flight[0], p -> new ArrayList<>())
            .add(new int[]{flight[1], flight[2]});
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, src, 0});
        while (!pq.isEmpty()){
            int val[] = pq.poll(), dist = val[0], node = val[1], level = val[2];
            if (level > stops[node] || level > k + 1){
                continue;
            }

            if (node == dst){
                return dist;
            }

            stops[node] = level;
            if (!map.containsKey(node)){
                continue;
            }

            for (int[] neighbor : map.get(node)){
                pq.offer(new int[] {dist + neighbor[1], neighbor[0], level + 1});
            }
        }

        return -1;
    }
}
