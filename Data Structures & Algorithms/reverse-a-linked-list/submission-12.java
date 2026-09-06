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
        ListNode curr = head;
        ListNode prev = null; // Convert head to tail. Now as tail, it points to nothing.

        // Preserve nodes. Use in-place
        while (curr != null) {
            // reverse pointer -> swap direction
            ListNode temp = curr.next;
            curr.next = prev;

            // update
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
