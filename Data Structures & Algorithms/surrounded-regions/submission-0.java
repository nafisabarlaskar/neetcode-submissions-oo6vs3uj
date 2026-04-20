class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if (m <= 2 || n <= 2) {
            return;
        }
        boolean[][] visited = new boolean[m][n];
        for (int j = 0; j < n; j++){
            dfs(board, 0, j, visited);
            dfs(board, m - 1, j, visited);
        }

        for (int i = 1; i < m - 1; i++){
            dfs(board, i, 0, visited);
            dfs(board, i, n - 1, visited);
        }

        for (int i = 1; i < m - 1; i++){
            for (int j = 1; j < n - 1; j++){
                if (!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] == 'X') {
            return;
        }
        
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            dfs(board, x, y, visited);
        }
    }
}
