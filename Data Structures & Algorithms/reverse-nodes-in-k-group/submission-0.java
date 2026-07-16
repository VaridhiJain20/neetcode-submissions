/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
          int size= size(head);
	        
	        int no_grps= size/k;
	        
	        ListNode[] arr= new ListNode[no_grps];
	        
	        ListNode temp = head;
	        
	        for (int i = 0; i < arr.length; i++) {
	        	ListNode nh= temp;
				for (int j = 1; j < k; j++) {
					temp= temp.next;
				}
			
				ListNode nn;
				
				if(temp.next!= null) {
				nn= temp.next;
				}
				else {
					nn = null;
				}
				temp.next=  null;
				arr[i]= nh;
				temp= nn;	
			}
	        
	        for (int i = 0; i < arr.length; i++) {
				arr[i]= reverseList(arr[i]);
			}
	        
	        ListNode nhead= new ListNode();
	        ListNode nn= nhead;
	        for (int i = 0; i < arr.length; i++) {
				nn.next= arr[i];
				
				while(nn.next!= null) {
					nn= nn.next;
				}
			}
	        
	        nn.next= temp;       
	        
	        return nhead.next;
	        
	    }
	  
	  
	  public ListNode reverseList(ListNode head) {

	        if(head== null){
	            return head;
	        }
	              ListNode prev= null;
		        ListNode curr= head;
		        
		        
		        while(curr!= null) {
		        	ListNode n= curr.next;
		        	
		        	curr.next= prev;
		        	prev= curr;
		        	curr= n;
		        }
			 
		        
		        
			 return prev;
	    }

	private int size(ListNode head) {
		// TODO Auto-generated method stub
		
	ListNode temp= head;
	int count=0;
	
	while(temp!= null) {
		temp= temp.next;
		count++;
	}
		return count;
    }
}