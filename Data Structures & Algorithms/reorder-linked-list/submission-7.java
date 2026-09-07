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
    public void reorderList(ListNode head) {
        /*
          []
            []

          [1]
            [1]

          [1, 2, 3]
            
            [1, 3, 2]

          [ 1 2 3 4 5]
            [ 1 5 2 4 3]


          [1, 2, 3, 4]
            [1, 4, 2, 3]

          [ 1 2 3 4 5 6]
            [ 1 6 2 5 3 4]
        */

        // implement 1st past fast pointer/ curr pointer to identify the node preceding the first node for filo. Then we will delete that nodes link to avoid acyclic list.
        // post condition: curr pointer will be [midpoint.next]
        ListNode curr = head;
        ListNode fast = head;

        // First pass - iterate until you reach the start of "large" indices
        while (fast != null && fast.next != null) {
            curr = curr.next;
            fast = fast.next.next;
        }

        // Delete the link preceding first node of filo. Preserve that link for selection in filo. All lists.size >= 1, so no npe
        fast = curr.next;
        curr.next = null;

        Deque<ListNode> stack = new ArrayDeque<>();

        // Apply a filo
        while (fast != null) {
            stack.push(fast);
            fast = fast.next;
        }

        // Stitch filo to list to create ordering
        curr = head;
        while (!stack.isEmpty()) {
            fast = curr.next; // just a temp, to preserve the link between lower ordered elements
            curr.next = stack.pop();
            curr.next.next = fast;
            curr = fast;
        }
    }
}
