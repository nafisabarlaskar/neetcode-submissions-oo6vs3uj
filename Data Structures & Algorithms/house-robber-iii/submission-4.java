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
public class Solution {
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }

        rob(root.left);
        rob(root.right);
        int robNode = root.val, dontRobNode = 0;
        if (root.left != null){
            dontRobNode += root.left.val;
            if (root.left.left != null){
                robNode += root.left.left.val;
            }

            if (root.left.right != null){
                robNode += root.left.right.val;
            }
        }

        if (root.right != null){
            dontRobNode += root.right.val;
            if (root.right.left != null){
                robNode += root.right.left.val;
            }

            if (root.right.right != null){
                robNode += root.right.right.val;
            }
        }

        root.val = Math.max(robNode, dontRobNode);
        return root.val;
    }
}