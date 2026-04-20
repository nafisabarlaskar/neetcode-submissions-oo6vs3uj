class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = grid[0][0], high = n * n - 1;
        while (low < high){
            int mid = low + (high - low)/2;
            if (dfs(grid, 0, 0, mid, new boolean[n][n])){
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean dfs(int[][] grid, int i, int j, int t, boolean[][] visited){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid.length || visited[i][j] || grid[i][j] > t){
            return false;
        }

        visited[i][j] = true;
        if (i == grid.length - 1 && j == grid.length - 1){
            return true;
        }
        
        return dfs(grid, i-1, j, t, visited)
             || dfs(grid, i+1, j, t, visited)
             || dfs(grid, i, j-1, t, visited)
             || dfs(grid, i, j+1, t, visited);
    }
}
