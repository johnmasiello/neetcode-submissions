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
        // Assume equals and hashcode on ListNode is just object identity.


        Set<ListNode> visited = new HashSet<>();

        while (head != null && !visited.contains(head)) {
            visited.add(head);
            head = head.next;
        }

        // heads points to some node in the list (for which all nodes were visited) AND non-empty list
        return head != null && !visited.isEmpty();
    }
}
