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
        ListNode curr = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        // Add the head of each list to a min heap
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        while (!pq.isEmpty()) {
            ListNode min = pq.poll();
            curr.next = min;

            // Restore min heap to take next node (current node) from list just polled
            if (min.next != null) {
                pq.offer(min.next);
            }

            // Update
            curr = min;
            min.next = null; // clean up link on node as defense
        }

        return dummy.next;
    }
}
