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
    int count;
    public int goodNodes(TreeNode root) {
      count=0;
	        count(root, Integer.MIN_VALUE);
	        return count;
	    }

	 private void count(TreeNode root, int max) {
		// TODO Auto-generated method stub
		if(root== null) {
			return ;
		}
		
		if(root.val>= max) {
			count++;
			max= root.val;
			}
		
		count(root.left, max);
		count(root.right, max);   
    }
}