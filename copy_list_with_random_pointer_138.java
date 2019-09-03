import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int val, Node next, Node random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
public class copy_list_with_random_pointer_138 {
    Map<Node, Node> isVisited = new HashMap<>();

    public Node copyRandomList_recursive(Node head) {
        if (head == null) return null;
        if (this.isVisited.containsKey(head)) {
            return this.isVisited.get(head);
        }
        Node node = new Node(head.val, null, null);
        this.isVisited.put(head, node);
        node.next = copyRandomList_recursive(head.next);
        node.random = copyRandomList_recursive(head.random);
        return node;
    }

    public Node getClonedNode(Node node) {
        if (node != null) {
            if (isVisited.containsKey(node)) {
                return isVisited.get(node);
            } else {
                isVisited.put(node, new Node(node.val, null, null));
                return isVisited.get(node);
            }
        }
        return null;
    }
    public Node copyRandomList_iterative(Node head) {
        if (head == null) return null;
        Node pre = head, cur = new Node(pre.val, null, null);
        isVisited.put(pre, cur);
        while (pre != null) {
            cur.random = getClonedNode(pre.random);
            cur.next = getClonedNode(pre.next);
            pre = pre.next;
            cur = cur.next;
        }
        return isVisited.get(head);
    }
    public Node copyRandomLIst_iterative_optim(Node head) {
        if (head == null) return null;
        Node ptr = head;
        while(ptr != null) {
            Node newNode = new Node(ptr.val,null, null);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        ptr = head;
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
