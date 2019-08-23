public class balanced_binary_tree_110 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x){this.val = x;}
    }
    public boolean isBalanced(TreeNode root) {
        return checkDepth(root) != -1;
    }
    public int checkDepth(TreeNode root) {
        if (root == null) return 0;
        int left = checkDepth(root.left);
        if (left == -1) return -1;
        int right = checkDepth(root.right);
        if (right == -1) return -1;
        int dif = Math.abs(left - right);
        if (dif > 1) return -1;
        else return 1 + Math.max(left, right);
    }
}
