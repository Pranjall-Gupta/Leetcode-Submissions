/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null) return head;
        Node curr=head;
        while(curr!=null){
            
            if(curr.child!=null){
                curr=childFlat(curr);
            }
            curr=curr.next;
            
        }
        return head;
    }
    private Node childFlat(Node n){
        Node child=n.child;
        Node next=n.next;

        n.next=child;
        child.prev=n;
        n.child=null;

        Node tail=child;
        while(tail!=null){
            if(tail.child!=null){
                tail=childFlat(tail);
            }
            if (tail.next == null) break; // we've reached the tail of this chain
            tail = tail.next;
        }
        if(next!=null){
            tail.next=next;
            next.prev=tail;
        }
        return tail;
    }
}