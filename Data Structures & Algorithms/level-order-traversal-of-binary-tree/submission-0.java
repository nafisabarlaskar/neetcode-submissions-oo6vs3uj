/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null){
            dfs(result, root, 0);
        }
        
        return result;
    }

    private void dfs(List<List<Integer>> result, TreeNode root, int level){
        if (level >= result.size()){
            result.add(level, new ArrayList<>());
        }

        result.get(level).add(root.val);
        if (root.left != null) {
            dfs(result, root.left, level + 1);
        }
        
        if (root.right != null) {
            dfs(result, root.right, level + 1);
        }
    }
}
