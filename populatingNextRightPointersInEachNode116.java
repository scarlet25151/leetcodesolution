import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class populatingNextRightPointersInEachNode116 {
    class Node {
        public int val;
        public Node left, right;
        public Node next;

        public Node() {}
        public Node(int _val, Node _left, Node _right, Node _next) {
            this.val = _val;
            this.left = _left;
            this.right = _right;
            this.next = _next;
        }
    }
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Node> oneLevelNodes = new ArrayList<>();
            for (int i = queue.size(); i > 0; --i) {
                Node node = queue.poll();
                oneLevelNodes.add(node);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            for (int i = 0; i < oneLevelNodes.size(); ++i) {
                oneLevelNodes.get(i).next = i == oneLevelNodes.size() - 1 ? null : oneLevelNodes.get(i + 1);
            }
        }
        return root;
    }

}
