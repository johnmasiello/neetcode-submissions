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
            [1 2] [3]
            
            [1, 3, 2]

          [ 1 2 3 4 5]
            [ 1 5 2 4 3]


          [1, 2, 3, 4]
            [1, 4, 2, 3]

          [ 1 2 3 4 5 6]
            [ 1 2 3 4] [6 5]
            [ 1 6 2 5 3 4]
        */

        // implement 1st past fast pointer/ curr pointer to identify the node preceding the first node for reverse sublist. Then we will delete that nodes link to avoid acyclic list.
        // post condition: curr pointer will be [midpoint.next]
        ListNode curr = head;
        ListNode fast = head;

        // First pass - iterate until you reach the start of "large" indices
        while (fast != null && fast.next != null) {
            curr = curr.next;
            fast = fast.next.next;
        }

        // Delete the link preceding first node of filo. Preserve that link for selection in reverse sublist. All lists.size >= 1, so no npe
        ListNode reversedList = curr.next;
        curr.next = null;

        // Apply a reverse sublist to the upper half
        // fast is pointing to the head of the reverse list
        reversedList = reverseList(reversedList);

        // Stitch filo to list to create ordering
        curr = head;
        while (reversedList != null) {
            ListNode temp = curr.next; // Preserve the link between lower ordered elements
            curr.next = reversedList;
            ListNode temp2 = reversedList.next; // Preserve the link between higher ordered elements
            reversedList.next = temp;

            // Advance the list for both list and reversed
            curr = temp;
            reversedList = temp2;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // | 1 2 3 4, prev null, curr 1
            // 1 | 2 3 4, prev 1, curr 2
            // 2 1 | 3 4, prev 2, curr 3
            // 3 2 1 | 4, prev 3, curr 4
            // 4 3 2 1, prev 4 curr null
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
