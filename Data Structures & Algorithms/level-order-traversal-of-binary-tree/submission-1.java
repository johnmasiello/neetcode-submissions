class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, 0, result);
        return result;
    }

    private void traverse(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // If this is the first time we've reached this level, create a new list for it.
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        // Add the current node's value to its corresponding level's list
        result.get(level).add(node.val);

        // Traverse left and right, incrementing the level
        traverse(node.left, level + 1, result);
        traverse(node.right, level + 1, result);
    }
}
