import java.util.ArrayDeque;

public class serializeAndDeserializedBST_449 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode (int x) {val = x;}
    }

    private StringBuilder postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return sb;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(' ');
        return sb;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postOrder(root, new StringBuilder());
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private TreeNode backtracking(int lower, int upper,
                                  ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) return null;
        int val = nums.removeLast();;
        if (val < lower || val > upper) return null;

        TreeNode root = new TreeNode(val);
        root.right = backtracking(val, upper, nums);
        root.left = backtracking(lower, val, nums);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split("\\s+"))
            nums.add(Integer.valueOf(s));
        return backtracking(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

}
