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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }

        dfs(root);
      
return ans;
    }

    public int dfs(TreeNode root){
      if(root== null){
        return 0;
      }  

        int l=0;
        if(root.left!=null){
            l= Math.max(l,dfs(root.left));
        }
        int r=0;
        if(root.right!=null){
            r= Math.max(r,dfs(root.right));
        }

        ans= Math.max(ans, root.val+l+r);


return Math.max(r, l)+root.val;
    }
}
