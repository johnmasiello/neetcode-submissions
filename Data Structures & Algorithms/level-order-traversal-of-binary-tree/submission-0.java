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
    // Use a queu, FIFO
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>(200); // More performant - contiguous block of memory optimizes L1 Cache for max N = 2000 items

        if (root == null) {
            return list;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesAcross = queue.size();
            List<Integer> inner = new ArrayList<>();

            for (int i = 0; i < nodesAcross; i++) {
                TreeNode node = queue.poll();
                inner.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(inner);
        }
        return list;
    }
}
