class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 0) {
                    queue.addLast(new int[]{ row, col });
                }
            }
        }

        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.pollFirst();
            for (int[] direction : directions) {
                int newRow = cell[0] + direction[0];
                int newCol = cell[1] + direction[1];
                if (newRow >= 0 && newCol >= 0 &&
                    newRow < grid.length &&
                    newCol < grid[0].length &&
                    grid[newRow][newCol] == Integer.MAX_VALUE) {
                    grid[newRow][newCol] = grid[cell[0]][cell[1]] + 1;
                    queue.addLast(new int[] { newRow, newCol });
                }
            }
        }
    }
}
