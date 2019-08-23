import java.util.*;

public class binary_tree_zigzag_level_order_traversal_103 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        q1.add(root);
        List<Integer> out = new ArrayList<>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                TreeNode node = q1.pop();
                out.add(node.val);
                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }
            if (!out.isEmpty()) res.add(out);
            out.clear();
            while (!q2.isEmpty()) {
                TreeNode node = q2.removeFirst();
                out.add(node.val);
                if (node.right != null) q1.add(node.right);
                if (node.left != null) q1.add(node.left);
            }
            if (!out.isEmpty()) res.add(out);
            out.clear();
        }
        return res;
    }
}
