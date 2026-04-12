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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = dfs(root.left), right = dfs(root.right);
        int sum = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max = Math.max(max, Math.max(sum, root.val + left + right));
        return sum;
    }
}
