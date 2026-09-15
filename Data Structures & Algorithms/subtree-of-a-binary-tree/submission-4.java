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
    // Using a naive approach for now - each node in root, check if subRoot isEqual
    // Time O(N * M) Complexity O(1)
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
