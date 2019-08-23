import java.util.*;

public class path_sumII_113 {
    private class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {this.val = x;}
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> out = new Stack<>();
        findPathSum(root, sum, res, out);
        return res;
    }
    public void findPathSum(TreeNode root, int sum,
                            List<List<Integer>> res, Stack<Integer> out) {
        if (root == null) return;
        out.push(root.val);
        if (sum == root.val && root.left == null && root.right == null) {
            List<Integer> tmp = new ArrayList<>(out);
            res.add(tmp);
        }
        findPathSum(root.left, sum - root.val, res, out);
        findPathSum(root.right, sum - root.val, res, out);
        out.pop();
    }
    public List<List<Integer>> solution2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root, pre = null;
        int val = 0;
        while(cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                val += cur.val;
                cur = cur.left;
            }
            cur = s.peek();
            if (cur.left == null && cur.right != null && val == sum) {
                List<Integer> p = new ArrayList<>();
                for (TreeNode it : s) {
                    p.add(it.val);
                }
                res.add(p);
            }
            if (cur.right != null && cur.right != pre)
                cur = cur.right;
            else {
                pre = cur.right;
                val -= cur.val;
                s.pop();
                cur = null;
            }
        }
        return res;
    }
}
