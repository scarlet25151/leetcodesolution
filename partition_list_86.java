public class partition_list_86 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode partition (ListNode head, int x) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode newdummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy, p = newdummy;
        while (cur.next != null) {
            if (cur.next.val < x) {
                p.next = cur.next;
                p = p.next;
                cur.next = cur.next.next;
                p.next = null;
            } else cur = cur.next;
        }
        p.next = dummy.next;
        return newdummy.next;
    }
}
