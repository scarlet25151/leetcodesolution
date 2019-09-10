public class reverseLinkedListII_92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}

    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; ++i) pre = pre.next;
        ListNode cur = pre.next;
        for (int i = m; i < n; ++i) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
        }
        return dummy.next;
    }
}
