class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null){
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int index){
        if (index == word.length()){
            return !node.word.equals("");
        }

        char c = word.charAt(index);
        if (c != '.'){
            if (node.children[c - 'a'] != null) {
                return dfs(word, node.children[c - 'a'], index + 1);
            }
        } else {
            for (int i = 0; i < node.children.length; i++){
                if (node.children[i] != null && dfs(word, node.children[i], index + 1)){
                    return true;
                }
            }
        }

        return false;
    }
}

class TrieNode {
    TrieNode[] children;
    String word = "";

    public TrieNode(){
        children = new TrieNode[26];
    }
}