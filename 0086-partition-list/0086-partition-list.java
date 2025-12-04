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
    public ListNode partition(ListNode head, int x) {
        ListNode dum=new ListNode(0,head);
        ListNode node=new ListNode(0);
        ListNode curr=node;
        ListNode slow=dum;
        ListNode fast=dum.next;;
        while(fast!=null){
            if(fast.val<x){
                fast=fast.next;
                slow=slow.next;
            }else{
                slow.next=fast.next;
                fast.next=null;
                curr.next=fast;
                curr=curr.next;
                fast=slow.next;
            }
        }

        if(node.next !=null)
            slow.next=node.next;
        return dum.next;
    }
}