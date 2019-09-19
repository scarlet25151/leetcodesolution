public class insertionSortList147 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1), cur = dummy;
        while (head != null) {
            ListNode next = head.next;
            cur = dummy;
            while (cur.next != null && cur.next.val <= head.val)
                cur = cur.next;
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return dummy.next;
    }
}
