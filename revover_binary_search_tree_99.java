import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class revover_binary_search_tree_99 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {this.val = x;}
    }
    public void inorder(TreeNode root, List<Integer> lists) {
        if (root == null) return;
        inorder(root.left, lists);
        lists.add(root.val);
        inorder(root.right, lists);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) x = nums.get(i);
                else break;
            }
        }
        return new int[] {x, y};
    }
    public void recover(TreeNode r, int count, int x, int y) {
        if (r != null) {
            if (r.val == x || r.val == y) {
                r.val = r.val == x ? y : x;
                if (--count == 0) return;
            }
            recover(r.left, count, x, y);
            recover(r.right, count, x, y);
        }
    }
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int swapped[] = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }
    public void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    public void recoverTree2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (pre != null && root.val < pre.val) {
                y = root;
                if (x == null) x = pre;
                else break;
            }
            pre = root;
            root = root.right;
        }
        swap(x, y);
    }

}
