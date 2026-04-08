class Solution {
    TrieNode root;
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        buildTrie(words, root);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                dfs(board, result, i, j, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, List<String> result, int i, int j, TrieNode node){
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || node == null || board[i][j] == '#'){
            return;
        }

        char c = board[i][j];
        if (node.child[c - 'a'] == null){
            return;
        }

        node = node.child[c - 'a'];
        if (node.word != null){
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        dfs(board, result, i + 1, j, node);
        dfs(board, result, i - 1, j, node);
        dfs(board, result, i, j + 1, node);
        dfs(board, result, i, j - 1, node);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words, TrieNode root){
        for (String word : words){
            TrieNode node = root;
            for (char c : word.toCharArray()){
                int index = c - 'a';
                if (node.child[index] == null){
                    node.child[index] = new TrieNode();
                }

                node = node.child[index];
            }

            node.word = word;
        }

        return root;
    }

    class TrieNode {
        TrieNode[] child;
        String word;

        public TrieNode(){
            child = new TrieNode[26];
        }
    }
}
