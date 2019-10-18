public class inorderSuccessorInBST285 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    private TreeNode pre = null, suc = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        inorderTraversal(root, p);
        return suc;
    }
    private void inorderTraversal(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorderTraversal(root.left, p);
        if (pre == p) suc = root;
        pre = root;
        inorderTraversal(root.right, p);
    }
}
