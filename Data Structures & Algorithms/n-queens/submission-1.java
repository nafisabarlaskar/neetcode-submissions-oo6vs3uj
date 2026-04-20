class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 0, n, new boolean[n], new boolean[n * 2], new boolean[n * 2]);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2){
        if (row == n){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int col = 0; col < n; col++){
            if (!cols[col] && !diag1[row + col] && !diag2[n + row - col]){
                char[] ch = new char[n];
                Arrays.fill(ch, '.');
                ch[col] = 'Q';
                list.add(new String(ch));
                cols[col] = true;
                diag1[row + col] = true;
                diag2[n + row - col] = true;
                dfs(result, list, row + 1, n, cols, diag1, diag2);
                cols[col] = false;
                diag1[row + col] = false;
                diag2[n + row - col] = false;
                list.removeLast();
            }
        }
    }
}
