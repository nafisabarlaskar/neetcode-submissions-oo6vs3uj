class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = n;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }

        for (int[] edge : edges){
            int parentX = find(edge[0], parent), parentY = find(edge[1], parent);
            if (parentX != parentY){
                parent[parentY] = parentX;
                count--;
            }
        }

        return count;
    }

    private int find(int x, int[] parent){
        if (parent[x] != x){
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }
}
