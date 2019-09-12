import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreePreorderTraversal144 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            res.add(node.val);
            if (node.right != null) nodeStack.push(node.right);
            if (node.left != null) nodeStack.push(node.left);
        }
        return res;
    }

}
