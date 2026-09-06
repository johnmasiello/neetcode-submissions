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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = new ListNode(head.val); // tail node points to nothing
        ListNode next = head.next;

        while (next != null) {
            previous = new ListNode(next.val, previous);
            next = next.next;
        }

        return previous;
    }
}
