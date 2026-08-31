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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[2];
        Arrays.fill(result, - 1);
        ArrayList<Integer> list = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = prev.next != null ? prev.next : null;
        ListNode next = curr.next != null ? curr.next : null;
        int idx = 2;
        while(next != null) {
            if(prev.val > curr.val && curr.val < next.val) {
                list.add(idx);
            }
            if(prev.val < curr.val && curr.val > next.val) {
                list.add(idx);
            }
            prev = curr;
            curr = next;
            next = next.next;
            idx ++;
        }
        int n = list.size();

        if(n <= 1) return result;

        int max = list.get(n - 1) - list.get(0);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        result[0] = min;
        result[1] = max;
        return result;
    }
}