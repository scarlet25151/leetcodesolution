import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class twoSumBSTs1214 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;}
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        inorderTravel(arr1, root1);
        inorderTravel(arr2, root2);
        HashSet<Integer> set = new HashSet<>();

        for (int num1 : arr1) {
            set.add(target - num1);
        }
        for (int num2 : arr2) {
            if (set.contains(num2)) {
                return true;
            }
        }
        return false;
    }

    private void inorderTravel(List<Integer> res, TreeNode root) {
        if (root == null) return;
        inorderTravel(res, root.left);
        res.add(root.val);
        inorderTravel(res, root.right);
    }

}
