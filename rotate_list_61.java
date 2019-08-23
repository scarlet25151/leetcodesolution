import java.util.*;
public class rotate_list_61 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {this.val = x;}
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int n = 1;
        ListNode cur = head;
        while (cur.next != null) {
            ++n;
            cur = cur.next;
        }
        cur.next = head;
        int m = n - k % n;
        for (int i = 0; i < m; ++i) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        return newHead;
    }
}
