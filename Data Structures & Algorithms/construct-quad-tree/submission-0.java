/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int i, int j, int len){
        if (areSame(grid, i, j, len)){
            return new Node(grid[i][j] == 1, true);
        } else {
            Node node = new Node(false, false);
            node.topLeft = build(grid, i, j, len/2);
            node.topRight = build(grid, i, j + len/2, len/2);
            node.bottomLeft = build(grid, i + len/2, j, len/2);
            node.bottomRight = build(grid, i + len/2, j + len/2, len/2);
            return node;
        }
    }

    private boolean areSame(int[][] grid, int x, int y, int length) {
        for (int i = x; i < x + length; i++){
            for (int j = y; j < y + length; j++){
                if (grid[i][j] != grid[x][y]){
                    return false;
                }
            }
        }

        return true;
    }
}