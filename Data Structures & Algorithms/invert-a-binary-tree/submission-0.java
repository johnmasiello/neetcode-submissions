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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        Deque<TreeNode> stack = new ArrayDeque<>(List.of(root));
        TreeNode node = root;

        // Swap left and right on current node, then add it's children to stack
        do {
            node = stack.pop();
            TreeNode swap = node.left;
            node.left = node.right;
            node.right = swap;
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        } while (!stack.isEmpty());
        
        return root;
    }
}
