/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Trust the equals and hash code for identity and good hash. And just use HashMap.

        Node curr = head;

        // Pass 1 - Clone the deep copy and link next. We interleave existing list with old list to create associative mapping. We do not care if original is messed up. We are NOT taking input integrity as constraint.

        while (curr != null) {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;

            // Update
            curr = temp;
        }

        // Pass 2 - 1. Link random cloned nodes using the implied mapping in interleaved nodes 2. Construct deep cloned linked list using the nodes from list of nodes. Scratch 2. We have to defer to restore the original input linked list.

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next; // A1 -> A1' -> A2 -> A2'. The orignal list node will points to its deep clone
            }
            // deepCurr.next = curr.next; // linking deep copy array with node copy

            // Update
            curr = curr.next.next;
            // deepCurr = deepCurr.next;
        }

        // Pass 3 - restore original array AND construct deepCopy, so test cases receive the input in untouched state

        Node deepCopy = new Node(0);
        Node deepCurr = deepCopy;

        curr = head;
        while (curr != null) {
            deepCurr.next = curr.next;
            curr.next = curr.next.next; // Guaranteed curr.next is not null by the interleaved duplicate clones

            // Update
            deepCurr = deepCurr.next;
            curr = curr.next;

            // Optimization - JVM iteration optimization shouldn't have dangling references
            deepCurr.next = null;
        }

        return deepCopy.next;
    }
}
