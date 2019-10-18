public class binaryNumberInLinkedList {
    public class SinglyLinkedListNode {
         int data;
         SinglyLinkedListNode next;
    }
    public long getNumber(SinglyLinkedListNode binary) {
        // Write your code here
        long res = 0;
        while (binary != null) {
            res = (res << 1) + binary.data;
            binary = binary.next;
        }
        return res;
    }
}
