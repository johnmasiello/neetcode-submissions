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
    // DFS -no recursion- with modification to defer removing the parent until after all its subtrees have been searched.
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> depthDeque = new ArrayDeque<>();

        int max = 0;
        deque.add(root);
        depthDeque.add(1);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            int currentDepth = depthDeque.pop();
            
            max = Math.max(max, currentDepth); 

            if (node.left != null) {
                deque.push(node.left);
                depthDeque.push(currentDepth + 1);
            }
            if (node.right != null) {
                deque.push(node.right);
                depthDeque.push(currentDepth + 1);
            }
        }
        return max;
    }
}
