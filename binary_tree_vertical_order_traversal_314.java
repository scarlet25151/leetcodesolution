import java.util.*;

public class binary_tree_vertical_order_traversal_314 {
    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    public class pair {
        int idx;
        TreeNode nd;
        pair (int idx, TreeNode nd) {
            this.idx = idx;
            this.nd = nd;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> m = new TreeMap<>();
        Deque<pair> q = new ArrayDeque<>();
        q.add(new pair(0, root));
        while (!q.isEmpty()) {
            pair a = q.removeLast();
            if (m.containsKey(a.idx)) {
                m.get(a.idx).add(a.nd.val);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(a.nd.val);
                m.put(a.idx, tmp);
            }
            if (a.nd.left != null) q.push(new pair(a.idx - 1, a.nd.left));
            if (a.nd.right != null) q.push(new pair(a.idx + 1, a.nd.right));
        }
        res.addAll(m.values());
        return res;
    }
}
