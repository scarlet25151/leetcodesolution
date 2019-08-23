public class construct_binary_tree_from_preorder_and_inorder_105 {
    private class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {
            this.val = x;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length -1,
                inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] preorder, int pleft, int pright,
                               int[] inorder, int ileft, int iright) {
        if (pleft > pright || ileft > iright) return null;
        int i = 0;
        for (i = ileft; i <= iright; ++i) {
            if (preorder[pleft] == inorder[i]) break;
        }
        TreeNode cur = new TreeNode(preorder[pleft]);
        cur.left = buildTree(preorder, pleft + 1, pleft + i - ileft,
                inorder, ileft, i - 1);
        cur.right = buildTree(preorder, pleft + i - ileft + 1, pright,
                inorder, i + 1, iright);
        return cur;
    }
}
