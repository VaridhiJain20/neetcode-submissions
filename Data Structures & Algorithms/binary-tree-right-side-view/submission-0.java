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
    public List<Integer> rightSideView(TreeNode root) {
        
	if( root== null)
			{
	return new ArrayList<>();
			}
	
	
	  Queue<TreeNode> q1= new LinkedList<>();
	  Queue<TreeNode> q2= new LinkedList<>();
	  

	  List<Integer> ans= new ArrayList<>();
	  
	  q1.offer(root);
	  
	  while(!q1.isEmpty()) {
		  TreeNode n= q1.poll();
		  
		 if(n.left!= null) q2.offer(n.left);
		 if(n.right!= null) q2.offer(n.right);
		  
		  if(q1.isEmpty()) {
			  ans.add(n.val);
			  
			  Queue<TreeNode> temp= q1;
			  q1= q2;
			  q2= temp;
		  }
	  }
	
	  
	  return ans;
	  
    }
}