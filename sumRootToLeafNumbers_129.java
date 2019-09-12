public class sumRootToLeafNumbers_129 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return sumNumbersDFS(root, sum);
    }
    private int sumNumbersDFS(TreeNode root, int sum) {
        if (root == null) return 0;
        sum += root.val;
        if (root.left == null && root.right == null)
            return sum;
        return sumNumbersDFS(root.left, sum) + sumNumbersDFS(root.right, sum);
    }
}
