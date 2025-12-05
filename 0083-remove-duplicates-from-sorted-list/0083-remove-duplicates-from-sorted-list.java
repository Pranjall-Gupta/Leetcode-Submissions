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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0,head);
        ListNode slow=dummy.next;
        ListNode fast=dummy.next.next;
        while(fast!=null){
            if(slow.val==fast.val){
                while(fast!=null && slow.val==fast.val){
                    fast=fast.next;
                }
                slow.next=fast;
            }else{
                slow=slow.next;
                fast=fast.next;
            }
        }
        return dummy.next;
    }
}