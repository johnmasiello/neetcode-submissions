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

/*
O(N * K) time complexity
O(1) space complexity
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        // Invariant: Running nodes is sorted, also ascending
        for (ListNode insertNode : lists) {
            ListNode curr = dummy;

            // Insert nodes from inner list, until running nodes runs out
            while (curr.next != null && insertNode != null) {
                if (insertNode.val < curr.next.val) {
                    ListNode temp = insertNode.next;
                    insertNode.next = curr.next;
                    curr.next = insertNode;

                    // Update
                    curr = insertNode;
                    insertNode = temp;
                } else {
                    curr = curr.next;
                }
            }

            // Insert all the remaining nodes in inner list to current running list
            if (insertNode != null) {
                curr.next = insertNode;
            }
        }

        return dummy.next;
    }
}
