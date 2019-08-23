import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Unique_BST_II_95 {
    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    public List<TreeNode> helper (int start, int end) {
        if (start > end) {
            List<TreeNode> no = new ArrayList<>();
            no.add(null);
            return no;
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = start; i <= end; ++i) {
            List<TreeNode> left = helper(start, i - 1), right = helper(i + 1, end);
            for(TreeNode a : left) {
                for (TreeNode b : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = a;
                    node.right = b;
                    res.add(node);
                }
            }
        }
        return res;
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> lists = new ArrayList<>();
        if (n == 0) return lists;
        return helper(1, n);
    }

}
