public class convert_sorted_array2BST_108 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {this.val = x;}
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return backtracking(nums, 0, nums.length - 1);
    }
    public TreeNode backtracking(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = backtracking(nums, left, mid - 1);
        cur.right = backtracking(nums, mid + 1, right);
        return cur;
    }
}
