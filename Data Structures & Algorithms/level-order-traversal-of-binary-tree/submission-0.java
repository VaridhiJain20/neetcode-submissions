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
    public List<List<Integer>> levelOrder(TreeNode root) {
        		
		 
		 List<List<Integer>>ans= new ArrayList<>();
		 
	        Queue<TreeNode> q1= new LinkedList<>();
	        Queue<TreeNode> q2= new LinkedList<>();   
	        
	       if(root!=null){q1.offer(root);} 
	        
	        List<Integer> nl= new ArrayList<>();
	        
	        while(!q1.isEmpty()) {
	        	TreeNode nn= q1.poll();
	        	
	        	nl.add(nn.val);
	        	
	        	if(nn.left!= null) {
	        		q2.offer(nn.left);
	        	}
	        	if(nn.right!= null) {
	        		q2.offer(nn.right);
	        	}
	        	
	        	if(q1.isEmpty()) {
	        		ans.add(new ArrayList<>(nl));
	        		nl= new ArrayList<>();
	        		
	        	    Queue<TreeNode> temp= q1;
	        	    q1= q2;
	        	    q2= temp;
	        	}
	        }
	        
	        return ans;
    }
}