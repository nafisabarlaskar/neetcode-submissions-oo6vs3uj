class Solution {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if (m == 0 || n == 0){
            return 0;
        }

        int[][] cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                max = Math.max(max, dfs(cache, matrix, i, j));
            }
        }

        return max;
    }

    private int dfs(int[][] cache, int[][] matrix, int i, int j){
        if (cache[i][j] != 0){
            return cache[i][j];
        }

        for (int[] dir : dirs){
            int x = dir[0] + i, y = dir[1] + j;
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]){
                cache[i][j] = Math.max(cache[i][j], dfs(cache, matrix, x, y));
            }
        }

        return ++cache[i][j];
    }
}
