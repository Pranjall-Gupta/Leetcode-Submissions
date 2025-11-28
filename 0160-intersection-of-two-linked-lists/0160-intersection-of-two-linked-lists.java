/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        int len1=0,len2=0;
        while(p1.next != null){
            len1++;
            p1=p1.next;
        }
        while(p2.next != null){
            len2++;
            p2=p2.next;
        }
        if(p1 != p2) return null;
        len1++;len2++;
        int diff;
        p2=headB;
        p1=headA;
        if(len1>len2){
            diff=len1-len2;
            for(int i=1;i<=diff;i++) p1=p1.next;

        }else{
            diff=len2-len1;
            for(int i=1;i<=diff;i++) p2=p2.next;
        }
        while(p1!=p2 && p1 !=null && p2 !=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}