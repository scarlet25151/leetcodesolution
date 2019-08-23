import java.util.*;
public class binary_tree_inorder_traversal_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
    public void helper (TreeNode root, List<Integer> lists) {
        if (root == null) return;
        helper(root.left, lists);
        lists.add(root.val);
        helper(root.right, lists);

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        helper(root, lists);
        return lists;
    }
}
