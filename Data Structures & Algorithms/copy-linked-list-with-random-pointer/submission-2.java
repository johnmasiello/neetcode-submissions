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

        Node dummy = new Node(0);
        Node deepPrev = dummy;
        Node deepCurr;

        Map<Node, Node> map = new HashMap<>();

        // Deep copy and link list nodes on next
        while (curr != null) {
            deepCurr = new Node(curr.val);
            map.put(curr, deepCurr); // key-value map on corresponding deep copy node

            // Link
            deepPrev.next = deepCurr;

            // Update
            deepPrev = deepCurr;
            curr = curr.next;
        }

        // Link random linked nodes in deep copy by mirroring random linked nodes in original
        curr = head;
        deepCurr = dummy.next;
        while (curr != null) {
            deepCurr.random = map.get(curr.random);

            // Update
            curr = curr.next;
            deepCurr = deepCurr.next;
        }

        return dummy.next;
    }
}
