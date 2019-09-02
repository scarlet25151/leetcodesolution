import java.util.Hashtable;

public class LRU_Cache_146 {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev, next;
    }

    private DLinkedNode head, tail;
    private int capacity;
    private int size;
    private Hashtable<Integer, DLinkedNode> cache =
            new Hashtable<>();

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        //Be careful the order can't be reversed
        head.next.prev = node;
        head.next = node;

    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
    private DLinkedNode popTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public LRU_Cache_146 (int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}