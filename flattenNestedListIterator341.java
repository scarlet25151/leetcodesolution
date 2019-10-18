import java.util.*;

public class flattenNestedListIterator341 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            for (NestedInteger n : nestedList) {
                add(n, queue);
            }
        }

        private void add(NestedInteger n, Queue<Integer> queue) {
            if (n.isInteger()) {
                queue.offer(n.getInteger());
            } else {
                for (NestedInteger nest : n.getList()) {
                    add(nest, queue);
                }
            }
        }

        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
