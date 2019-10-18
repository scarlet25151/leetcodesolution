import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class findMedianFromDataStream295 {
    class MedianFinder {
        private Queue<Integer> smallHeap, largeHeap;
        /** initialize your data structure here. */
        public MedianFinder() {
            smallHeap = new PriorityQueue<>();
            largeHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            smallHeap.offer(num);
            largeHeap.offer(-smallHeap.poll());
            if (smallHeap.size() < largeHeap.size()) {
                smallHeap.offer(-largeHeap.poll());
            }
        }

        public double findMedian() {
            return smallHeap.size() > largeHeap.size() ?
                    smallHeap.peek() : 0.5 * (smallHeap.peek() - largeHeap.peek());
        }
    }

}
