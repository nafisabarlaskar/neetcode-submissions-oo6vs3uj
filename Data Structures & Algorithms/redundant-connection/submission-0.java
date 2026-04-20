class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n], rank = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges){
            if (!union(edge[0] - 1, edge[1] - 1, parent, rank)){
                return edge;
            }
        }

        return new int[0];
    }

    private int find(int x, int[] parent){
        if (x != parent[x]){
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }

    private boolean union(int x, int y, int[] parent, int[] rank){
        int parentX = find(x, parent), parentY = find(y, parent);
        if (parentX == parentY){
            return false;
        }

        if (rank[parentY] < rank[parentX]){
            parent[parentY] = parentX;
        } else if (rank[parentY] > rank[parentX]){
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }

        return true;
    }
}
