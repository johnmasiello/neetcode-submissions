/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    // ALGO 1
    // Using a naive approach for now - each node in root, check if subRoot isEqual
    // Time O(N * M) Complexity O(1)
    //
    // BRAINSTORM
    // One enhancement would be to do an isSubtree search at the same time as the equals.
    // If in the traversal path you encounter a lead node you should start there. However, we cannot generalize what a 'lead' node is in subtree, because it's head might not be unique. If you create an example, like a fractal of parent 2, child 4, child 5; child 4 and child 5 have children 2 in subroot, always choosing to move down the start point of traversal in parent can be a mistake.
    //
    // There are incidentals to think about that create guardrails. Like if you just traverse all of subroot and all of root, you could compare if subroot has more nodes or greater depth than root as a boundary condition. These narrow the search field for possible subtrees of root.
    //
    /*
    ALGO 2

    Implement isSubtree as an is-equals. But when you encounter a node in root with same value as subroot,
    then you generalize (or logic) with subroot at that node in root, with continuing down the is equals on subnode of subroot. You need to pass current node of subRoot, plus the original subRoot given in input. Now you no longer need to traverse in an outer loop on root.

    One thing to keep in mind is that you started with root, so you cannot call recursively there with root and subroot, else you get infinite loop. That means you have to check left and right children of root if they are equal to subroot, and you call the isSubtree against children of root and subRoot
    */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) { // edge case - short circuits for empty subtree
            return true;
        }

        if (isEqual(root, subRoot)) {
            return true;
        } else if (root != null) {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        } else {
            return false;
        }
    }

    public boolean _isSubtree(TreeNode root, TreeNode subRoot) {
        return false;
    }

    // Time O(N) Complexity O(1)
    public boolean isEqual(TreeNode a, TreeNode b) {
        if (a == b) {
            return true;
        } else if (a != null && b != null && a.val == b.val) {
            return isEqual(a.left, b.left) && isEqual(a.right, b.right);
        } else {
            return false;
        }
    }
}
