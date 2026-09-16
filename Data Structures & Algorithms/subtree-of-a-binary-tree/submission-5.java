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
        String rootStr = serializeTree(root);
        String subRootStr = serializeTree(subRoot);
        // System.out.println(rootStr);
        // System.out.println(subRootStr);
        return rootStr.indexOf(subRootStr) > -1;
    }

    // Time O(N) Space O(1)
    public String serializeTree(TreeNode root) {
        if (root == null) {
            return "n";
        }
        return "" + root.val + "," + serializeTree(root.left) + "," + serializeTree(root.right);
    }
}
