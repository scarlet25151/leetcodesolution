import java.util.Stack;

public class BST_Iterator_173 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    Stack<TreeNode> treeNodes;
    public BST_Iterator_173(TreeNode root) {
        treeNodes = new Stack<>();
        leftmostInOrder(root);
    }
    private void leftmostInOrder(TreeNode root) {
        while (root != null) {
            treeNodes.push(root);
            root = root.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode res = treeNodes.pop();
        if (res.right != null)
            leftmostInOrder(res.right);
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return treeNodes.size() > 0;
    }
}
