class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
        || word.charAt(index) != board[i][j]){
            return false;
        }

        if (index == word.length() - 1){
            return true;
        }

        char c = board[i][j];
        board[i][j] = '#';
        if (dfs(board, word, index + 1, i + 1, j)
        || dfs(board, word, index + 1, i - 1, j)
        || dfs(board, word, index + 1, i, j + 1)
        || dfs(board, word, index + 1, i, j - 1)) {
            return true;
        }
        board[i][j] = c;
        return false;
    }
}
