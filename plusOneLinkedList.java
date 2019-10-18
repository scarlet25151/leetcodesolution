import java.util.List;

public class plusOneLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        ListNode revHead = reverse(head);
        ListNode cur = revHead;
        ListNode pre = cur;
        int carry = 1;

        while(cur != null) {
            pre = cur;
            int t = cur.val + carry;
            cur.val = t % 10;
            carry = t / 10;
            if (carry == 0) break;
            cur = cur.next;
        }
        if (carry != 0) pre.next = new ListNode(1);
        return reverse(revHead);
    }
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        dummy.next = cur;
        while (cur.next != null) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = dummy.next;
            dummy.next = t;
        }
        return dummy.next;
    }
}

