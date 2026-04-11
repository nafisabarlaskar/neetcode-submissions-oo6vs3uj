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
        List<List<Integer>> list = new ArrayList<>();
        if (root != null){
            dfs(list, 0, root);
        }
        
        return list;
    }

    private void dfs(List<List<Integer>> list, int level, TreeNode root){
        if (list.size() <= level){
            list.add(level, new ArrayList<>());
        }

        list.get(level).add(root.val);
        if (root.left != null){
            dfs(list, level + 1, root.left);
        }

         if (root.right != null){
            dfs(list, level + 1, root.right);
        }
    }
}
