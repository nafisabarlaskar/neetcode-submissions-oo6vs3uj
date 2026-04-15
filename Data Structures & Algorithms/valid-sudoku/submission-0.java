class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] count;
        for (int i = 0; i < 9; i++){
            count = new int[9];
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    count[board[i][j] - '1']++;
                    if (count[board[i][j] - '1'] > 1){
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++){
            count = new int[9];
            for (int j = 0; j < 9; j++){
                if (board[j][i] != '.'){
                    count[board[j][i] - '1']++;
                    if (count[board[j][i] - '1'] > 1){
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                count = new int[9];
                for (int k = 3 * i; k < 3 * i + 3; k++){
                    for (int p = 3 * j; p < 3 * j + 3; p++){
                        if (board[k][p] != '.'){
                            count[board[k][p] - '1']++;
                            if (count[board[k][p] - '1'] > 1){
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
