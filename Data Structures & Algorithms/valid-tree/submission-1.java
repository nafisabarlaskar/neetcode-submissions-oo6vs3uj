class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1){
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (!dfs(0, -1, visited, graph)){
            return false;
        }

        return visited.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> visited, List<List<Integer>> graph){
        if (visited.contains(node)){
            return false;
        }

        visited.add(node);
        for (int neighbor : graph.get(node)){
            if (neighbor != parent){
                if (!dfs(neighbor, node, visited, graph)){
                    return false;
                }
            }
        }

        return true;
    }
}
