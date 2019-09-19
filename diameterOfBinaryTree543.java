public class diameterOfBinaryTree543 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {val = x;}
    }
    public int res;
    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return res;
    }
    private int findMax(TreeNode root) {
        if (root == null) return 0;
        int left = findMax(root.left);
        int right = findMax(root.right);
        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }
}
