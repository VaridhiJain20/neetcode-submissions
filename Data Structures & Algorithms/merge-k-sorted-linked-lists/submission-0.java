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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq= new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val- o2.val;
			}
			 
		 });

         for(ListNode l: lists){
            if(l!=null){
                pq.offer(l);
            }}

        ListNode head= new ListNode();
        ListNode temp= head;

        while(!pq.isEmpty()){
            temp.next= pq.poll();
            temp= temp.next;
            if(temp.next!=null){
            pq.offer(temp.next);
            }
        }
            
         
    temp.next=null;

         return head.next;

    }
}
