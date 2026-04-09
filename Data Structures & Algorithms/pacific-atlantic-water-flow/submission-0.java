class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] p = new boolean[m][n], a = new boolean[m][n];
        for (int i = 0; i < m; i++){
            dfs(i, 0, p, heights);
            dfs(i, n - 1, a, heights);
        }

        for (int i = 0; i < n; i++){
            dfs(0, i, p, heights);
            dfs(m - 1, i, a, heights);
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (p[i][j] && a[i][j]){
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, boolean[][] arr, int[][] heights) {
        arr[i][j] = true;
        for (int[] dir : dirs){
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && y >= 0 && x < heights.length && y < heights[0].length
             && !arr[x][y] && heights[x][y] >= heights[i][j]){
                dfs(x, y, arr, heights);
             }
        }
    }
}
