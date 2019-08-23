import java.util.List;

public class convert_sorted_list2BST {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {this.val = x;}
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {this.val = x;}
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return backtracking(head, null);
    }
    public TreeNode backtracking(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode cur = new TreeNode(slow.val);
        cur.left = backtracking(head, slow);
        cur.right = backtracking(slow.next, tail);
        return cur;
    }
}
