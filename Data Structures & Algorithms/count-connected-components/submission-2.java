class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = n;
        for (int[] edge : edges){
            int parentX = find(edge[0], parent), parentY = find(edge[1], parent);
            if (parentX != parentY){
                count--;
                parent[parentY] = parentX;
            }
        }

        return count;
    }

    private int find(int x, int[] parent){
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }
}


