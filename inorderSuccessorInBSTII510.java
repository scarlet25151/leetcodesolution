public class inorderSuccessorInBSTII510 {
    public class Node {
        public int val;
        public Node left, right;
        public Node parent;
    }
    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        if (x.right != null) {
            x = x.right;
            while (x.left != null) x = x.left;
            return x;
        }
        while (x != null) {
            if (x.parent == null) return null;
            if (x == x.parent.left) return x.parent;
            x = x.parent;
        }
        return x;
    }
}
