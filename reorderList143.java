public class reorderList143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }
    public void reorderList(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slowPoint = head, fastPoint = head;
        // Find mid node
        while (fastPoint.next != null && fastPoint.next.next != null) {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next.next;
        }
        ListNode midNode = slowPoint.next;
        slowPoint.next = null;
        // Reverse node
        ListNode last = midNode, pre = null;
        while (last != null) {
            ListNode next = last.next;
            last.next = pre;
            pre = last;
            last = next;
        }
        while (head != null && pre != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = pre.next;
            head.next.next = next;
            head = next;
        }
    }
}
