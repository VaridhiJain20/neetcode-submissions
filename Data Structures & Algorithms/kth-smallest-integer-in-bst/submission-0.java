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
    int i=0;
    int ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        i=0;
        ans= root.val;
        inorder(root,k);
        return ans;
    }

    public void inorder(TreeNode root, int k){
        if(i>k){
            return;
        }
        if(root==null){
            return;
        }
              
        inorder(root.left, k);
           i++;
            if(i==k){
            ans= root.val;
            return;
        }
       
        inorder(root.right, k);

       
    }
}
