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
        ListNode next = head.next;
        ListNode previous = head;
        previous.next = null; // Convert head to tail. Now as tail, it points to nothing.

        // Preserve nodes. Use in-place
        while (next != null) {
            // reverse pointer -> swap direction
            ListNode temp = next.next;
            next.next = previous;

            // update
            previous = next;
            next = temp;
        }

        return previous;
    }
}
