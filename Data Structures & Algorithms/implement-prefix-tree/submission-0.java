class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null){
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    public boolean search(String word) {
        TrieNode node = prefixSearch(word);
        return node != null && word.equals(node.word);
    }

    public boolean startsWith(String prefix) {
        TrieNode node = prefixSearch(prefix);
        return node != null;
    }

    private TrieNode prefixSearch(String prefix){
        TrieNode node = root;
        for (char c : prefix.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null){
                return null;
            }

            node = node.children[index];
        }

        return node;
    }
}

class TrieNode {
    TrieNode[] children;
    String word;
    public TrieNode(){
        this.children = new TrieNode[26];
    }
}
