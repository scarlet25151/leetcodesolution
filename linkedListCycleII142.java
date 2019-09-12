import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class linkedListCycleII142 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        int idx = 0;
        ListNode curNode = head;
        Map<ListNode, Integer> nodeIndex = new HashMap<>();
        while(curNode != null) {
            if (nodeIndex.containsKey(curNode)) return curNode;
            else
                nodeIndex.put(curNode, idx++);
            curNode = curNode.next;
        }
        return null;
    }
}
