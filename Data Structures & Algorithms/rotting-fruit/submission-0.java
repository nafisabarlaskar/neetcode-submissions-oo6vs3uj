class Solution {
    public int orangesRotting(int[][] grid) {
        int max = 0, m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    q.offer(new int[] {i, j, 0});
                }
            }
        }

        while (q.size() > 0){
            int[] cell = q.poll();
            int r = cell[0], c = cell[1], time = cell[2];
            max = Math.max(max, time);
            for (int[] dir : dirs){
                int x = r + dir[0], y = c + dir[1];
                if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1){
                    grid[x][y] = 2;
                    q.offer(new int[] {x, y, time + 1});
                }
            }
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return max;
    }
}
