import java.util.*;

public class insertDeleteGetRandomO1DuplicateAllowed381 {
    static class RandomizedCollection {
        private Stack<Integer> nums;
        private Map<Integer, PriorityQueue<Integer>> map;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            nums = new Stack<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            PriorityQueue<Integer> heap;
            if (!map.containsKey(val))
                heap = new PriorityQueue<>();
            else
                heap = map.get(val);
            heap.offer(nums.size());
            map.put(val, heap);
            nums.push(val);
            return map.get(val).size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).isEmpty()) return false;
            int idx = map.get(val).poll();
            if (nums.size() - 1!= idx) {
                int last = nums.peek();
                nums.set(idx, last);
                map.get(last).poll();
                map.get(last).offer(idx);
            }
            nums.pop();
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }
    public static void main(String[] args) {
        RandomizedCollection obj = new RandomizedCollection();
        obj.insert(9);
        obj.insert(9);
        obj.insert(1);
        obj.insert(1);
        obj.insert(2);
        obj.insert(1);
        obj.remove(2);
        obj.remove(1);
        obj.remove(1);
        obj.insert(9);
        obj.remove(1);
    }
}