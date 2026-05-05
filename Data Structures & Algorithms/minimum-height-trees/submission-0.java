class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0 || n == 1){
            return Arrays.asList(0);
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] edge : edges){
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++){
            if (indegree[i] == 1){
                q.offer(i);
            }
        }

        while (n > 2){
            int size = q.size();
            n -= size;
            while (size-- > 0){
                int node = q.poll();
                for (int neighbor : graph.get(node)){
                    indegree[neighbor]--;
                    if (indegree[neighbor] == 1){
                        q.offer(neighbor);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (q.size() > 0){
            result.add(q.poll());
        }

        return result;
    }
}