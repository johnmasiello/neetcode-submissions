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

/* Algo:

  Visit all nodes you can. If a node is revisited, then it is a cyclic list. An empty list is vacuously non cyclic.
*/
class Solution {
    public boolean hasCycle(ListNode head) {
        // Dummy helps us avoid nullpointer on fast points, and helps us avoid false positive on cyclic for empty lists
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy.next;

        while (slow != fast && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }

        // heads points to some node in the list (for which all nodes were visited) AND non-empty list
        return slow == fast;
    }
}
