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
            Node copy = curr.next;
            curr.next = copy.next;       // Restore original list link (A1 -> A2)
            deepCurr.next = copy;        // Attach copy to new list (deep -> A1')
            deepCurr = copy;             // Move deepCurr to A1'
            curr = curr.next;            // Move curr to A2

            // JVM optimization on iteration - explicitly remove dangling reference to original node in list
            deepCurr.next = null;
        }

        return deepCopy.next;
    }
}
