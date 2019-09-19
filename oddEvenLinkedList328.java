import java.util.List;

public class oddEvenLinkedList328 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}
