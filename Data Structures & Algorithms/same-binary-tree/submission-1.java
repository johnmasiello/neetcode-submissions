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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> stackP = new ArrayDeque<>();
        Deque<TreeNode> stackQ = new ArrayDeque<>();

        if ((p == null) ^ (q == null)) { // case exactly one node is null
            return false;
        } else if (p == null) { // case both nodes are null
            return true;
        }

        stackP.push(p);
        stackQ.push(q);

        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();

            if (nodeP.val != nodeQ.val) {
                return false;
            }

            // Child nodes should mirror leaf | non-leaf structure
            if (((nodeP.left == null) ^ (nodeQ.left == null)) || ((nodeP.right == null) ^ (nodeQ.right == null))) {
                return false;
            } 
            if (nodeP.left != null) {
                stackP.push(nodeP.left);
                stackQ.push(nodeQ.left);
            }
            if (nodeP.right != null) {
                stackP.push(nodeP.right);
                stackQ.push(nodeQ.right);
            }
        }

        return true;
    }
}
