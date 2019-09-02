import java.util.ArrayList;
import java.util.List;

public class boundary_of_binary_tree_545 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    private void leftBoundary(TreeNode node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null))
            return;
        res.add(node.val);
        if (node.left == null) leftBoundary(node.right, res);
        else leftBoundary(node.left, res);
    }
    private void rightBoundary(TreeNode node, List<Integer> res) {
        if (node == null || (node.left == null && node.right == null))
            return;
        if (node.right == null) rightBoundary(node.left, res);
        else rightBoundary(node.right, res);
        res.add(node.val);
    }
    private void childBoundary(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (node.left == null && node.right == null) res.add(node.val);
        childBoundary(node.left, res);
        childBoundary(node.right, res);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left != null || root.right != null) res.add(root.val);
        leftBoundary(root.left, res);
        childBoundary(root, res);
        rightBoundary(root.right, res);
        return res;
    }
}
