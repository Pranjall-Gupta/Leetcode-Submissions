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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return head;
        ListNode dum=new ListNode(0,head);
        ListNode prev=dum;
        ListNode slow=dum.next;
        ListNode fast=dum.next.next;

        while(fast!=null){
            prev.next=fast;
            slow.next=fast.next;
            fast.next=slow;
            if(slow.next==null)break;
            prev=slow;
            slow=slow.next;
            fast=fast.next.next.next;
        }
        return dum.next;
    }
}