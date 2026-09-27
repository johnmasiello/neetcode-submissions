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
    public boolean isValidBST(TreeNode root) {
        return isValidBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST2(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        return (root.left == null || (min < root.left.val && root.left.val < root.val)) && (root.right == null || (root.val < root.right.val && root.right.val < max)) && isValidBST2(root.left, min, root.val) && isValidBST2(root.right, root.val, max);
    }
}
