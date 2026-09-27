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
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, new int[] {k});
    }

    public int kthSmallest(TreeNode root, int[] k) {
        if (root != null) {
            int val = kthSmallest(root.left, k);
            if (k[0] == 0) {
                // Propagating kth smallest back up
                return val;
            }
            k[0]--;
            if (k[0] == 0) {
                // Found kth smallest in BST
                return root.val;
            }
            val = kthSmallest(root.right, k);
            if (k[0] == 0) {
                // Propagating kth smallest back up
                return val;
            }
        }
        return 0;
    }
}
