public class reverse_nodes_in_k_group25 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), pre = dummy, cur = pre;
        dummy.next = head;
        int num = 0;
        while (cur.next != null) {
            cur = cur.next;
            ++num;
        }
        while (num >= k) {
            cur = pre.next;
            for (int i = 1; i < k; ++i) {
                ListNode t = cur.next;
                cur.next = t.next;
                t.next = pre.next;
                pre.next = t;
            }
            pre = cur;
            num -= k;
        }
        return dummy.next;
    }
}
