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
        int[] tuple = new int[] {k, -1};
        kthSmallest(root, tuple);
        return tuple[1];
    }

    // state[0] is k - counting down kth smallest node
    // state[1] is the kth smallest value in BST
    public void kthSmallest(TreeNode root, int[] state) {
        if (root != null && state[0] != 0) {
            kthSmallest(root.left, state);
            state[0]--;
            if (state[0] == 0) {
                // Found kth smallest in BST
                state[1] = root.val;
            }
            kthSmallest(root.right, state);
        }
    }
}
