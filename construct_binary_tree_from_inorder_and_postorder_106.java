public class construct_binary_tree_from_inorder_and_postorder_106 {
    private class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {
            this.val = x;
        }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] inorder, int ileft, int iright,
                               int[] postorder, int pleft, int pright) {
        if (ileft > iright || pleft > pright) return null;
        int i = 0;
        for (i = ileft; i < iright; ++i) {
            if (inorder[i] == postorder[pright]) break;
        }
        TreeNode cur = new TreeNode(postorder[pright]);
        cur.left = buildTree(inorder, ileft, i - 1,
                postorder, pleft, pleft + i - ileft -1);
        cur.right = buildTree(inorder, i + 1, iright,
                postorder, pleft + i - ileft, pright -1);
        return cur;
    }
}
