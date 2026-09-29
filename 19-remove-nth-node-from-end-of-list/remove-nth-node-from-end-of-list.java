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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);
        int node = len - n;
        if(node == 0) return head.next;
        ListNode prev = head;
        ListNode temp = head;
        int curr = 0;
        while(curr != node && temp != null) {
            prev = temp;
            temp = temp.next;
            curr++;
        }
        if(temp != null) {
            prev.next = temp.next;
        }
        return head;
    }
    public int length(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }
}