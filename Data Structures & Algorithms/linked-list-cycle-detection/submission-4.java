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
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}
