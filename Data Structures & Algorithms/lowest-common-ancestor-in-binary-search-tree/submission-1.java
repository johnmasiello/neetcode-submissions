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
    // Time complexity: O(H) where H is the height of the tree. Space complexity O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = root;

        // Invariant p.val <= q.val
        int pVal = p.val < q.val ? p.val : q.val;
        int qVal = p.val < q.val ? q.val : p.val;

        // Guarantee both p and q values are in tree having root
        // Perform binary search until p.val <= lca.val <= q.val
        // LCA is a common ancestor node, so one search
        while (pVal > lca.val || qVal < lca.val) {
            if (pVal > lca.val) {
                lca = lca.right;
            } else {
                lca = lca.left;
            }
        }
        return lca;
    }
}
