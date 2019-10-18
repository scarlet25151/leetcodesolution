import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreePath257 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder out = new StringBuilder("");
        backtracking(root, res, out);
        return res;
    }

    private void backtracking(TreeNode root, List<String> res, StringBuilder out) {
        if (root == null) {
            out.delete(out.length() - 2, out.length() - 1);
            res.add(out.toString());
            return;
        }
        String valString = String.valueOf(root.val) + "->";
        out.append(valString);
        backtracking(root.left, res, out);
        backtracking(root.right, res, out);
        out.delete(out.length() - valString.length(), out.length() - 1);
    }

}
