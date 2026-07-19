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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return bt(preorder, inorder,0,preorder.length-1, 0,inorder.length-1);
    }

    public TreeNode bt(int[]p, int[] in, int ps, int pl, int is, int il){
        if(ps>pl ||is>il){
            return null;
        }
        int v=p[ps];
        TreeNode root= new TreeNode(v);
        
        int ct=0;

        for(int i=is; i<=il; i++){
            if(in[i]==v){
                break;
            }
            else{
                ct++;
            }
        }

        root.left= bt(p, in, ps+1,ps+ct,is, is+ct-1);
        root.right= bt(p, in, ps+ct+1, pl, is+ct+1, il);

        return root;
    }
}