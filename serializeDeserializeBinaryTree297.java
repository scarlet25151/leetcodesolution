import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class serializeDeserializeBinaryTree297 {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x;};
    }
    public class Codec {

        // Encodes a tree to a single string.

        public String serialize(TreeNode root) {
            return serialize(root, "");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] dataArray = data.split(",");
            List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
            return deserialize(dataList);
        }

        private String serialize(TreeNode root, String s) {
            if (root == null) {
                s += "null,";
            } else {
                s += String.valueOf(root.val) + ",";
                s = serialize(root.left, s);
                s = serialize(root.right, s);
            }
            return s;
        }
        private TreeNode deserialize(List<String> list) {
            if (list.get(0).equals("null")) {
                list.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = deserialize(list);
            root.right = deserialize(list);
            return root;
        }
    }

}
