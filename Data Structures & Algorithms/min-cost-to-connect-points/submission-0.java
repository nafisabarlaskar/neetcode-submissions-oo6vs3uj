class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // Step 1: Build all edges
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) +
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{cost, i, j});
            }
        }

        // Step 2: Sort edges by cost
        Collections.sort(edges, (a, b) -> a[0] - b[0]);

        // Step 3: Union-Find
        UnionFind uf = new UnionFind(n);
        int totalCost = 0;
        int edgesUsed = 0;

        for (int[] edge : edges) {
            int cost = edge[0], u = edge[1], v = edge[2];
             if (uf.union(u, v)) { // if no cycle
                totalCost += cost;
                edgesUsed++;

                if (edgesUsed == n - 1) break;
            }
        }

        return totalCost;
    }
}


class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }
    public boolean union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return false; // cycle

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }
}
