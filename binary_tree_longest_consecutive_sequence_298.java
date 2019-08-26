public class binary_tree_longest_consecutive_sequence_298 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0, root.val);
        return res;
    }
    private void dfs (TreeNode root, int out, int v) {
        if (root == null) return;
        if (root.val == v + 1) out++;
        else out = 1;
        res = Math.max(res, out);
        dfs(root.left, out, root.val);
        dfs(root.right, out, root.val);
    }
}
