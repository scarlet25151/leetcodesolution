public class subtree_of_another_tree {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSametree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSametree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }
}
