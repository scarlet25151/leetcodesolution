public class remove_Nth_node_from_list_19 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {this.val = x;}
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n > 0)
            return null;
        int length = 0;
        ListNode res = head;
        while(res.next != null) {
            length++;
            res = res.next;
        }
        int removeIndex = length - n;
        res = head;
        for (int i = 0; i < removeIndex; ++i) {
            res = res.next;
        }
        res.next = res.next.next;
        return head;
    }
}
