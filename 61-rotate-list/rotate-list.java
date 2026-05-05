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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int n=len(head);
        k=k%n;
        if(k==0) return head;
        int split=n-k;
        int count=1;
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null && count<=split){
            count++;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        ListNode dummy=new ListNode(0);
        ListNode newNode=dummy;
        newNode.next=temp;
        while(newNode.next!=null){
            newNode=newNode.next;
        }
        newNode.next=head;
        return dummy.next;
    }
    public int len(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}