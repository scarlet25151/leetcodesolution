import java.util.*;

public class Merge_k_Sorted_Lists_23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode point = new ListNode(0), head = point;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l1;
                l1 = point.next.next;
            }
            point = point.next;
        }
        if (l1 == null) point.next = l2;
        else point.next = l1;
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int amount = lists.length, interval = 1;
        if (amount <= 0) return null;
        while (interval < amount) {
            for (int i = 0; i < amount - interval; i += interval * 2)
                lists[i] = merge2Lists(lists[i], lists[i + interval]);
            interval *= 2;
        }
        return lists[0];

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListNode point  = new ListNode(0);
        System.out.println(point.next);
    }
}
