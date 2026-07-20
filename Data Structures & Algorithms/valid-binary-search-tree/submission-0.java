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
    public class bst{
        int max;
        int min;
        boolean is;

        public bst(int max, int min, boolean is){
            this.max= max;
            this.min= min;
            this.is= is;
        }
    }


    public boolean isValidBST(TreeNode root) {
        return fn(root).is;

    }

    public bst fn(TreeNode root){
        if(root==null){
            return new bst(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        bst l=fn(root.left);
        bst r= fn(root.right);


        boolean is= l.is && r.is && root.val>l.max && root.val<r.min;
        int min= Math.min(root.val, Math.min(l.min, r.min));
        int max= Math.max(root.val, Math.max(l.max, r.max));

        bst self= new bst(max, min, is);
        return self;
    }
}
