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
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;

        // Give the fast pointer a lead start by n. 
        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        // Post condition: slow points to the n + 1 element from the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth element from the end of the list by pointing the (n+1)th elementh from the end to its next.next

        // Splice operation with dummy as head is guaranteed even for delete head node edge case
        slow.next = slow.next.next;

        // return the safe and connected head node
        return dummy.next;
    }
}
