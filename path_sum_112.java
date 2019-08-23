public class path_sum_112 {
    private class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {this.val = x;}
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null)
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }

}
