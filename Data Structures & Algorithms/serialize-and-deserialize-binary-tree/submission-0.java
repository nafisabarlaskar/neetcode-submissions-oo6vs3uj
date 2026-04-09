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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serialize(root, new StringBuilder("")).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(arr));
        return deserialize(list);
    }

    private StringBuilder serialize(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append("null,");
        } else {
            sb.append(root.val).append(",");
            sb = serialize(root.left, sb);
            sb = serialize(root.right, sb);
        }

        return sb;
    }

    private TreeNode deserialize(List<String> list){
        String val = list.get(0);
        list.remove(0);
        if (val.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
