public class remove_duplicates_From_sorted_listII82 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1), pre = dummy;
        dummy.next = head;
        while (pre.next != null) {
            ListNode cur = pre.next;
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            if (cur != pre.next) pre.next = cur.next;
            else pre = pre.next;
        }
        return dummy.next;
    }
}
