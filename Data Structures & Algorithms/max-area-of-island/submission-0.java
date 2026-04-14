class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                max = Math.max(max, dfs(grid, i, j, visited));
            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0){
            return 0;
        }

        visited[i][j] = true;
        return 1
         + dfs(grid, i + 1, j, visited)
         + dfs(grid, i - 1, j, visited)
         + dfs(grid, i, j + 1, visited)
         + dfs(grid, i, j - 1, visited);
    }
}
