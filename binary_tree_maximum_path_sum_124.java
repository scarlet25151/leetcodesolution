public class binary_tree_maximum_path_sum_124 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        dfs(root);
        return res;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        res = Math.max(res, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
    // N denote the number of nodes;
    // time complexity: O(N) because we never visit each node more than 2 times;
    // space complexity: O(log(N)) we need to have backtrack along
    // the whole tree.
}
