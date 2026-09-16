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
    // Using a linear serialization approach as first step and second step use optmized String.indexOf for 
    // time complexity O(N + M) and space complexity O(N + M)
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return serializeTree(root, new StringBuilder()).toString().indexOf(serializeTree(subRoot, new StringBuilder()).toString()) > -1;
    }

    // Time O(N) Space O(1)
    public StringBuilder serializeTree(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb.append("n");
        } 
        sb.append(",").append(root.val).append(",");
        serializeTree(root.left, sb).append(",");
        serializeTree(root.right, sb);
        return sb;
    }
}
