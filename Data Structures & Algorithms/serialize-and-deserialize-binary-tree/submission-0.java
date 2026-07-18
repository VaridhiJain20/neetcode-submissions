/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return ".";
        }
        return ""+ root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    int i;
    public TreeNode deserialize(String data) {
        String []arr= data.split(",");
        int i=0;


        return build(arr);
    }

    public TreeNode build(String[] arr){
        if(arr[i].equals(".")){
            i++;
            
            return null;
        }
        TreeNode nn= new TreeNode(Integer.parseInt(arr[i]));
        i++;
        nn.left= build(arr);
        nn.right= build(arr);

        return nn;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));