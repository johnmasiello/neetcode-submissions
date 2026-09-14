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
        TreeNode evictedNode = new TreeNode(); // dummy

        int maxDepth = 1;
        int depth = 1;
        deque.add(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.peek();
            int size = deque.size();

            if (node.left == evictedNode || node.right == evictedNode) {
                // Case current node is parent of evicted node. In that case, current node has already been visisted, and should also be evicted node.
                evictedNode = deque.pop();
                depth--;
                continue;
            } 

            if (node.left != null) {
                deque.push(node.left);
            }
            if (node.right != null) {
                deque.push(node.right);
            }

            if (deque.size() > size) {
                depth++;
                if (depth > maxDepth) {
                    maxDepth = depth;
                }
            } else { // case leaf node
                evictedNode = deque.pop();
            }
        }
        return maxDepth;
    }
}
