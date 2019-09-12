public class flattenBinaryTreeToLinkedList114 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        TreeNode lastLeave = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) root = root.right;
        root.right = lastLeave;
    }
}
