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
        if(root==null){
            return ".";
        }

        return ""+ root.val+ ","+serialize(root.left)+","+ serialize(root.right);
    }

    int i;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr= data.split(",");
        i=0;

        return build(arr);
    }

    public TreeNode build(String[] arr){
        if(arr[i].equals(".")){
            i++;
            return null;

        }

        TreeNode root= new TreeNode(Integer.parseInt(arr[i]));
        i++;
        root.left= build(arr);
        root.right= build(arr);

        return root;
    }
}
